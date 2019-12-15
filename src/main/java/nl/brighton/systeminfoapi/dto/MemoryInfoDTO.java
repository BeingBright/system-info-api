package nl.brighton.systeminfoapi.dto;

import java.util.ArrayList;
import java.util.Objects;

public class MemoryInfoDTO {
    private long total;
    private long available;
    private long pageSize;
    private ArrayList<PhysicalMemoryDTO> physicalMemory;

    public MemoryInfoDTO() {
        this.physicalMemory = new ArrayList<>();
    }

    public MemoryInfoDTO(long total, long available, long pageSize, ArrayList<PhysicalMemoryDTO> physicalMemory) {
        this.total = total;
        this.available = available;
        this.pageSize = pageSize;
        this.physicalMemory = physicalMemory;
    }

    public long getTotal() {
        return total;
    }

    public long getAvailable() {
        return available;
    }

    public long getPageSize() {
        return pageSize;
    }

    public ArrayList<PhysicalMemoryDTO> getPhysicalMemory() {
        return physicalMemory;
    }

    public boolean add(PhysicalMemoryDTO physicalMemoryDTO) {
        return physicalMemory.add(physicalMemoryDTO);
    }

    public boolean contains(PhysicalMemoryDTO physicalMemoryDTO) {
        return physicalMemory.contains(physicalMemoryDTO);
    }

    public boolean remove(PhysicalMemoryDTO physicalMemoryDTO) {
        return physicalMemory.remove(physicalMemoryDTO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryInfoDTO that = (MemoryInfoDTO) o;
        return total == that.total &&
                available == that.available &&
                pageSize == that.pageSize &&
                Objects.equals(physicalMemory, that.physicalMemory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, available, pageSize, physicalMemory);
    }

    @Override
    public String toString() {
        return "MemoryInfoDTO{" +
                "total=" + total +
                ", available=" + available +
                ", pageSize=" + pageSize +
                ", physicalMemory=" + physicalMemory +
                '}';
    }
}
