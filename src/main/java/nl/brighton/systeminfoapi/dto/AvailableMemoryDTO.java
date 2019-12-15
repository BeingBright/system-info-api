package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class AvailableMemoryDTO {
    private long available;

    public AvailableMemoryDTO(long available) {
        this.available = available;
    }

    public long getAvailable() {
        return available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailableMemoryDTO that = (AvailableMemoryDTO) o;
        return available == that.available;
    }

    @Override
    public int hashCode() {
        return Objects.hash(available);
    }

    @Override
    public String toString() {
        return "AvailableMemoryDTO{" +
                "available=" + available +
                '}';
    }
}
