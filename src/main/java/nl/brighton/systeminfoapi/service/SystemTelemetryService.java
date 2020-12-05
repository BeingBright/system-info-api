package nl.brighton.systeminfoapi.service;

import java.io.File;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.Display;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.hardware.PowerSource;
import oshi.hardware.Sensors;
import oshi.hardware.SoundCard;
import oshi.hardware.UsbDevice;
import oshi.software.os.FileSystem;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSProcess;
import oshi.software.os.OSService;
import oshi.software.os.OperatingSystem;

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
