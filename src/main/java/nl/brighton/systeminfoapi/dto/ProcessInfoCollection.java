package nl.brighton.systeminfoapi.dto;

import java.util.ArrayList;
import java.util.Objects;

public class ProcessInfoCollection {

    private ArrayList<ProcessInfoDTO> processes;

    public ProcessInfoCollection(ArrayList<ProcessInfoDTO> processes) {
        this.processes = processes;
    }

    public ArrayList<ProcessInfoDTO> getProcesses() {
        return processes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessInfoCollection that = (ProcessInfoCollection) o;
        return Objects.equals(processes, that.processes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processes);
    }

    @Override
    public String toString() {
        return "ProcessInfoCollection{" +
                "processes=" + processes +
                '}';
    }

    public boolean add(ProcessInfoDTO processInfoDTO) {
        return processes.add(processInfoDTO);
    }

    public boolean contains(ProcessInfoDTO processInfoDTO) {
        return processes.contains(processInfoDTO);
    }

    public boolean remove(ProcessInfoDTO processInfoDTO) {
        return processes.remove(processInfoDTO);
    }
}
