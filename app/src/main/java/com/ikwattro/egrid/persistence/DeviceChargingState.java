package com.ikwattro.egrid.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "device_charging")
public class DeviceChargingState {

    @Id
    @Column(name = "device_id")
    private UUID deviceId;

    @Column(name = "charging_level")
    private int chargeLevel;

    public DeviceChargingState() {
    }

    public DeviceChargingState(UUID deviceId, int chargeLevel) {
        this.deviceId = deviceId;
        this.chargeLevel = chargeLevel;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public void setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
    }
}
