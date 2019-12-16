package nl.brighton.systeminfoapi.dto;

import java.util.ArrayList;
import java.util.Objects;

public class DiskInfoCollection {

    private ArrayList<DiskInfoDTO> disks;

    public DiskInfoCollection() {
        disks = new ArrayList<>();
    }

    public DiskInfoCollection(ArrayList<DiskInfoDTO> disks) {
        this.disks = disks;
    }

    public ArrayList<DiskInfoDTO> getDisks() {
        return disks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiskInfoCollection that = (DiskInfoCollection) o;
        return Objects.equals(disks, that.disks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disks);
    }

    @Override
    public String toString() {
        return "MemoryInfoCollection{" +
                "collection=" + disks +
                '}';
    }

    public boolean add(DiskInfoDTO diskInfoDTO) {
        return disks.add(diskInfoDTO);
    }

    public boolean contains(DiskInfoDTO diskInfoDTO) {
        return disks.contains(diskInfoDTO);
    }

    public boolean remove(DiskInfoDTO diskInfoDTO) {
        return disks.remove(diskInfoDTO);
    }
}

