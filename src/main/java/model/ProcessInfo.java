package model;

import java.io.Serializable;

public class ProcessInfo implements Serializable {
    private int pId;
    private String pName;
    private double pInCPU;
    private double pInMEM;
    private String pVSZ;
    private String pRSS;

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

    public ProcessInfo() {
    }

    public ProcessInfo(int pId, String pName, double pInCPU, double pInMEM, String pVSZ, String pRSS) {
        this.pId = pId;
        this.pName = pName;
        this.pInCPU = pInCPU;
        this.pInMEM = pInMEM;
        this.pVSZ = pVSZ;
        this.pRSS = pRSS;
    }

    @Override
    public String toString() {
        return "ProcessInfo{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", pInCPU='" + pInCPU + '\'' +
                ", pInMEM='" + pInMEM + '\'' +
                ", pVSZ='" + pVSZ + '\'' +
                ", pRSS='" + pRSS + '\'' +
                '}';
    }
}
