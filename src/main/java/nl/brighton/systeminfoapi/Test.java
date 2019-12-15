package nl.brighton.systeminfoapi;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class Test {

//    public static void main(String[] args) {
//        SystemInfoDTO systemInfoDTO = new SystemInfoDTO(
//                System.getProperty("os.name"),
//                System.getProperty("os.arch"),
//                System.getProperty("os.version"),
//                System.getProperty("java.version"),
//                System.getProperty("java.vm.version"),
//                System.getProperty("java.vm.name")
//        );
//        System.out.println(systemInfoDTO);
//
//
//        CPUInfoDTO cpuInfoDTO = new CPUInfoDTO(
//                Runtime.getRuntime().availableProcessors()
//        );
//        System.out.println(cpuInfoDTO);
//
//        DiskInfoCollection infoCollection = new DiskInfoCollection();
//        File[] roots = File.listRoots();
//
//        for (File root : roots) {
//            infoCollection.add(
//                    new DiskInfoDTO(
//                            root.getAbsolutePath(),
//                            root.getTotalSpace(),
//                            root.getFreeSpace(),
//                            root.getUsableSpace()
//                    )
//            );
//        }
//        System.out.println(infoCollection);
//
//// _____________________________________________________
//
//
//    }

    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
        CentralProcessor centralProcessor = hardwareAbstractionLayer.getProcessor();

        ComputerSystem computerSystem = hardwareAbstractionLayer.getComputerSystem();

        System.out.println(operatingSystem.toString());
        System.out.println(centralProcessor.toString());
        System.out.println(computerSystem.toString());
        System.out.println(hardwareAbstractionLayer.getMemory().getPhysicalMemory()[0].getBankLabel());
        System.out.println(hardwareAbstractionLayer.getMemory().getPhysicalMemory()[0].getCapacity());
        System.out.println(hardwareAbstractionLayer.getMemory().getPhysicalMemory()[0].getClockSpeed());
        System.out.println(hardwareAbstractionLayer.getMemory().getPhysicalMemory()[0].getManufacturer());
        System.out.println(hardwareAbstractionLayer.getMemory().getPhysicalMemory()[0].getMemoryType());
        System.out.println(hardwareAbstractionLayer.getMemory().getAvailable() / 1000000000f);

        for (var i :
                centralProcessor.getLogicalProcessors()) {
            System.out.println("________");
            System.out.println(i.getNumaNode());
            System.out.println(i.getPhysicalPackageNumber());
            System.out.println(i.getPhysicalProcessorNumber());
            System.out.println(i.getProcessorGroup());
            System.out.println(i.getProcessorNumber());
            System.out.println("________");
        }

        for (var process : operatingSystem.getProcesses()) {
            System.out.println(process.getName());
            System.out.println(process.getKernelTime());
            System.out.println(process.getParentProcessID());
            System.out.println(process.getProcessID());
            System.out.println(process.getUserID());
            System.out.println(process.getUpTime());
        }

        for (var process : hardwareAbstractionLayer.getNetworkIFs()) {
            System.out.println("________");
            System.out.println(process.getName());
            System.out.println("IPv4");
            for (String addr : process.getIPv4addr()) {
                System.out.println(addr);
            }
            System.out.println("IPv6");
            for (String addr : process.getIPv6addr()) {
                System.out.println(addr);
            }
            System.out.println(process.getBytesSent());
            System.out.println(process.getBytesRecv());
            System.out.println(process.getPacketsRecv());
            System.out.println(process.getPacketsSent());
            System.out.println("________");
        }
    }
}
