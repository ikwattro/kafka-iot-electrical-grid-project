package com.ikwattro.egrid.service;

import com.ikwattro.egrid.DeviceEvent;
import com.ikwattro.egrid.persistence.DeviceChargingState;
import com.ikwattro.egrid.persistence.repository.DeviceChargingStateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class DeviceChargingRepositoryService {

    private final DeviceChargingStateRepository deviceChargingStateRepository;

    public DeviceChargingRepositoryService(DeviceChargingStateRepository deviceChargingStateRepository) {
        this.deviceChargingStateRepository = deviceChargingStateRepository;
    }

    public void storeDeviceChargingState(DeviceEvent deviceEvent) {
        if (deviceChargingStateRepository.existsById(UUID.fromString(deviceEvent.getDeviceId()))) {
            update(deviceEvent);
        } else {
            deviceChargingStateRepository.save(new DeviceChargingState(UUID.fromString(deviceEvent.getDeviceId()), deviceEvent.getCurrentCapacity()));
        }
    }

    public void update(DeviceEvent deviceEvent) {
        deviceChargingStateRepository.updateChargingLevelForDevice(deviceEvent.getCurrentCapacity(), UUID.fromString(deviceEvent.getDeviceId()));
    }
}
