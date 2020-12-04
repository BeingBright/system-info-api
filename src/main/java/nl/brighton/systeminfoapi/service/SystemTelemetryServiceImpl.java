package nl.brighton.systeminfoapi.service;

import java.io.File;
import org.springframework.stereotype.Service;
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

@Service
public class SystemTelemetryServiceImpl implements SystemTelemetryService {

  SystemInfo systemInfo = new SystemInfo();
  HardwareAbstractionLayer hardware = systemInfo.getHardware();
  OperatingSystem operatingSystem = systemInfo.getOperatingSystem();

  @Override
  public File[] getRoots() {
    return File.listRoots();
  }

  @Override
  public SystemInfo getSystemInfo() {
    return systemInfo;
  }

  @Override
  public HardwareAbstractionLayer getHardware() {
    return systemInfo.getHardware();
  }

  @Override
  public NetworkIF[] getNetworkIfs() {
    return hardware.getNetworkIFs();
  }

  @Override
  public GlobalMemory getMemory() {
    return hardware.getMemory();
  }

  @Override
  public ComputerSystem getComputerSystem() {
    return hardware.getComputerSystem();
  }

  @Override
  public HWDiskStore[] getDisks() {
    return hardware.getDiskStores();
  }

  @Override
  public Display[] getDisplays() {
    return hardware.getDisplays();
  }

  @Override
  public PowerSource[] getPowerSource() {
    return hardware.getPowerSources();
  }

  @Override
  public Sensors getSensors() {
    return hardware.getSensors();
  }

  @Override
  public SoundCard[] getSoundCards() {
    return hardware.getSoundCards();
  }

  @Override
  public UsbDevice[] getUsbDevices(boolean b) {
    return hardware.getUsbDevices(b);
  }

  @Override
  public OperatingSystem getSystem() {
    return operatingSystem;
  }

  @Override
  public OSProcess[] getProcesses() {
    return operatingSystem.getProcesses();
  }

  @Override
  public OSProcess getProcess(int index) {
    return operatingSystem.getProcess(index);
  }

  @Override
  public OSProcess getProcess(int index, boolean b) {
    return operatingSystem.getProcess(index, b);
  }

  @Override
  public int getBitVersion() {
    return operatingSystem.getBitness();
  }

  @Override
  public String getManufacturer() {
    return operatingSystem.getManufacturer();
  }

  @Override
  public String getFamily() {
    return operatingSystem.getFamily();
  }

  @Override
  public FileSystem getFileSystem() {
    return operatingSystem.getFileSystem();
  }

  @Override
  public NetworkParams getNetworkParams() {
    return operatingSystem.getNetworkParams();
  }

  @Override
  public int getProcessCount() {
    return operatingSystem.getProcessCount();
  }

  @Override
  public OSService[] getOsServices() {
    return operatingSystem.getServices();
  }

  @Override
  public long getSystemBootTime() {
    return operatingSystem.getSystemBootTime();
  }

  @Override
  public long getSystemUpTime() {
    return operatingSystem.getSystemUptime();
  }

  @Override
  public int getThreadCount() {
    return operatingSystem.getThreadCount();
  }

  @Override
  public OperatingSystem.OSVersionInfo getOsVersionInfo() {
    return operatingSystem.getVersionInfo();
  }

  @Override
  public CentralProcessor getProcessor() {
    return null;
  }
}
