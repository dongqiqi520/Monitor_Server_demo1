package Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MonitorRequest implements Serializable {
    private boolean isNeedProcess;
    private List<ProcessRequest> ProcessList=new ArrayList<>();
    public boolean isNeedProcess() {
        return isNeedProcess;
    }

    public void setNeedProcess(boolean needProcess) {
        isNeedProcess = needProcess;
    }

    public List<ProcessRequest> getProcessList() {
        return ProcessList;
    }

    public void setProcessList(List<ProcessRequest> processList) {
        ProcessList = processList;
    }

    @Override
    public String toString() {
        return "MonitorRequest{" +
                "isNeedProcess=" + isNeedProcess +
                ", ProcessList=" + ProcessList +
                '}';
    }
}
