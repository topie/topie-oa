package com.topie.spi.device;

public interface DeviceConnector {
    DeviceDTO findDevice(String code);

    void saveDevice(DeviceDTO deviceDto);
}
