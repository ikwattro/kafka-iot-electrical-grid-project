package com.ikwattro.egrid.controller;

import com.ikwattro.egrid.domain.DeviceChargingStateView;
import com.ikwattro.egrid.service.DeviceChargingStateQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ChargingStateController {

    private final DeviceChargingStateQueryService deviceChargingStateQueryService;

    public ChargingStateController(DeviceChargingStateQueryService deviceChargingStateQueryService) {
        this.deviceChargingStateQueryService = deviceChargingStateQueryService;
    }

    @GetMapping("/devices/{uuid}/charge")
    public DeviceChargingStateView chargingStateView(@PathVariable UUID uuid) {
        return deviceChargingStateQueryService.chargingStateViewForDeviceId(uuid);
    }
}
