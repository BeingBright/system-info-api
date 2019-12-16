package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class CPUCoreDTO {
    private long currentFrequency;
    private int processorNumber;

    public CPUCoreDTO(long currentFrequency, int processorNumber) {
        this.currentFrequency = currentFrequency;
        this.processorNumber = processorNumber;
    }

    public long getCurrentFrequency() {
        return currentFrequency;
    }

    public int getProcessorNumber() {
        return processorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPUCoreDTO that = (CPUCoreDTO) o;
        return currentFrequency == that.currentFrequency &&
                processorNumber == that.processorNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentFrequency, processorNumber);
    }

    @Override
    public String toString() {
        return "CPUCoreDTO{" +
                "currentFrequency=" + currentFrequency +
                ", processorNumber=" + processorNumber +
                '}';
    }
}
