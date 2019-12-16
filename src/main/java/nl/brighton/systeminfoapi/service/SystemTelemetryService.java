package nl.brighton.systeminfoapi.service;

import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.*;

import java.io.File;

public interface SystemTelemetryService {

    File[] getRoots();

    SystemInfo getSystemInfo();

    HardwareAbstractionLayer getHardware();

    NetworkIF[] getNetworkIfs();

    GlobalMemory getMemory();

    ComputerSystem getComputerSystem();

    HWDiskStore[] getDisks();

    Display[] getDisplays();

    PowerSource[] getPowerSource();

    Sensors getSensors();

    SoundCard[] getSoundCards();

    UsbDevice[] getUsbDevices(boolean b);

    OperatingSystem getSystem();

    OSProcess[] getProcesses();

    OSProcess getProcess(int index);

    OSProcess getProcess(int index, boolean b);

    int getBitVersion();

    String getManufacturer();

    String getFamily();

    FileSystem getFileSystem();

    NetworkParams getNetworkParams();

    int getProcessCount();

    OSService[] getOsServices();

    long getSystemBootTime();

    long getSystemUpTime();

    int getThreadCount();

    OperatingSystem.OSVersionInfo getOsVersionInfo();

    CentralProcessor getProcessor();

}
