package com.ikwattro.egrid.service;

import com.ikwattro.egrid.domain.DeviceChargingStateView;
import com.ikwattro.egrid.persistence.DeviceChargingState;
import com.ikwattro.egrid.persistence.repository.DeviceChargingStateRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class DeviceChargingStateQueryService {

    private final DeviceChargingStateRepository repository;

    public DeviceChargingStateQueryService(DeviceChargingStateRepository repository) {
        this.repository = repository;
    }

    public DeviceChargingStateView chargingStateViewForDeviceId(UUID deviceId) {
        DeviceChargingState state = repository.findById(deviceId).orElseThrow(EntityNotFoundException::new);

        return new DeviceChargingStateView(state.getDeviceId(), state.getChargeLevel());
    }
}
