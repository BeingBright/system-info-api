package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class ProcessInfoDTO {

    private int processID;
    private String name;
    private long kernelTime;
    private int parentProcessID;
    private String userID;
    private long upTime;
    private int priority;
    private long bytesRead;
    private long bytesWritten;
    private int bitness;


    public ProcessInfoDTO(int processID, String name, long kernelTime, int parentProcessID, String userID, long upTime, int priority, long bytesRead, long bytesWritten, int bitness) {
        this.processID = processID;
        this.name = name;
        this.kernelTime = kernelTime;
        this.parentProcessID = parentProcessID;
        this.userID = userID;
        this.upTime = upTime;
        this.priority = priority;
        this.bytesRead = bytesRead;
        this.bytesWritten = bytesWritten;
        this.bitness = bitness;
    }

    public int getProcessID() {
        return processID;
    }

    public String getName() {
        return name;
    }

    public long getKernelTime() {
        return kernelTime;
    }

    public int getParentProcessID() {
        return parentProcessID;
    }

    public String getUserID() {
        return userID;
    }

    public long getUpTime() {
        return upTime;
    }

    public int getPriority() {
        return priority;
    }

    public long getBytesRead() {
        return bytesRead;
    }

    public long getBytesWritten() {
        return bytesWritten;
    }

    public int getBitness() {
        return bitness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessInfoDTO that = (ProcessInfoDTO) o;
        return processID == that.processID &&
                kernelTime == that.kernelTime &&
                parentProcessID == that.parentProcessID &&
                upTime == that.upTime &&
                priority == that.priority &&
                bytesRead == that.bytesRead &&
                bytesWritten == that.bytesWritten &&
                bitness == that.bitness &&
                Objects.equals(name, that.name) &&
                Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processID, name, kernelTime, parentProcessID, userID, upTime, priority, bytesRead, bytesWritten, bitness);
    }

    @Override
    public String toString() {
        return "ProcessInfoDTO{" +
                "processID=" + processID +
                ", name='" + name + '\'' +
                ", kernelTime=" + kernelTime +
                ", parentProcessID=" + parentProcessID +
                ", userID='" + userID + '\'' +
                ", upTime=" + upTime +
                ", priority=" + priority +
                ", bytesRead=" + bytesRead +
                ", bytesWritten=" + bytesWritten +
                ", bitness=" + bitness +
                '}';
    }
}
