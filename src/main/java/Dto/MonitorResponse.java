package Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MonitorResponse implements Serializable {
    private boolean isNeedProcess;
    private List<ProcessResponse> ProcessList=new ArrayList<>();

    public boolean isNeedProcess() {
        return isNeedProcess;
    }

    public void setNeedProcess(boolean needProcess) {
        isNeedProcess = needProcess;
    }

    public List<ProcessResponse> getProcessList() {
        return ProcessList;
    }

    public void setProcessList(List<ProcessResponse> processList) {
        ProcessList = processList;
    }

    @Override
    public String toString() {
        return "MonitorResponse{" +
                "isNeedProcess=" + isNeedProcess +
                ", ProcessList=" + ProcessList +
                '}';
    }
}
