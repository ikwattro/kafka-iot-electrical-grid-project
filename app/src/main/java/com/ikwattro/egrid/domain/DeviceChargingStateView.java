package com.ikwattro.egrid.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class DeviceChargingStateView {

    UUID deviceId;

    int chargingLevel;
}
