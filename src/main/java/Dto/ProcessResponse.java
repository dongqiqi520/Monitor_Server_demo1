package Dto;

import model.ProcessInfo;

import java.io.Serializable;

public class ProcessResponse implements Serializable {

    private int pId;
    private String pName;
    private boolean status;
    private double pInCPU;
    private double pInMEM;
    private String pVSZ;
    private String pRSS;

    public ProcessResponse(ProcessRequest processRequest, boolean status){
        pId= processRequest.getPid();
        pName= processRequest.getPname();
        this.status=status;
    }

    public ProcessResponse(ProcessInfo processInfo,boolean status){
        pId=processInfo.getpId();
        pName=processInfo.getpName();
        this.status=status;
        pInCPU=processInfo.getpInCPU();
        pInMEM=processInfo.getpInMEM();
        pVSZ=processInfo.getpVSZ();
        pRSS=processInfo.getpRSS();
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getpInCPU() {
        return pInCPU;
    }

    public void setpInCPU(double pInCPU) {
        this.pInCPU = pInCPU;
    }

    public double getpInMEM() {
        return pInMEM;
    }

    public void setpInMEM(double pInMEM) {
        this.pInMEM = pInMEM;
    }

    public String getpVSZ() {
        return pVSZ;
    }

    public void setpVSZ(String pVSZ) {
        this.pVSZ = pVSZ;
    }

    public String getpRSS() {
        return pRSS;
    }

    public void setpRSS(String pRSS) {
        this.pRSS = pRSS;
    }

    @Override
    public String toString() {
        return "ProcessResponse{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", status=" + status +
                ", pInCPU=" + pInCPU +
                ", pInMEM=" + pInMEM +
                ", pVSZ='" + pVSZ + '\'' +
                ", pRSS='" + pRSS + '\'' +
                '}';
    }
}
