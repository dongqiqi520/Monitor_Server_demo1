package socketServer;

import Dto.MonitorRequest;
import Dto.MonitorResponse;
import Dto.ProcessRequest;
import Dto.ProcessResponse;
import model.ProcessInfo;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ServerHandleThread implements Runnable{
    private Socket socket;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;
    private InputStream inputStream;
    private ObjectInputStream objectInputStream;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    public ServerHandleThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            inputStream = socket.getInputStream();
            objectInputStream=new ObjectInputStream(inputStream);
            //readObject()方法必须保证服务端和客户端的Object包名一致，要不然会出现找不到类的错误
            /*List<ProcessInfo> processInfo=(List<ProcessInfo>)objectInputStream.readObject();*/
            ProcessInfo processInfo=(ProcessInfo)objectInputStream.readObject();
            System.out.println("客户端发送的对象：" + processInfo.toString());

            outputStream=socket.getOutputStream();
            printWriter=new PrintWriter(outputStream);
            printWriter.println("收到tasklist！");
            printWriter.flush();

            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);

            MonitorRequest monitorRequest=new MonitorRequest();
            monitorRequest.setNeedProcess(true);
            ProcessRequest processRequest=new ProcessRequest();
            processRequest.setPid(89760);
            processRequest.setPname("QQ.exe");
            List<ProcessRequest> processRequestList=new ArrayList<>();
            processRequestList.add(processRequest);
            monitorRequest.setProcessList(processRequestList);
            objectOutputStream.writeObject(monitorRequest);
            objectOutputStream.flush();

            while (true){
                inputStream = socket.getInputStream();
                if(inputStream==null)
                    continue;
                objectInputStream=new ObjectInputStream(inputStream);
                MonitorResponse monitorResponse=(MonitorResponse)objectInputStream.readObject();
                System.out.println("客户端发送的对象：" + monitorResponse.toString());
            }



        } catch (SocketException e){
            System.out.println("Scket 已断开！");
            try {
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally
        {
            try{
                if(printWriter!=null){
                    printWriter.close();
                }
                if(outputStream!=null){
                    outputStream.close();
                }
                if(objectOutputStream!=null){
                    objectOutputStream.close();
                }
                if(inputStream!=null){
                    inputStream.close();
                }
                if(objectInputStream!=null){
                    objectInputStream.close();
                }
                if(socket!=null){
                    socket.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("啦啦啦啦");
        }
    }

}
