package com.ikwattro.egrid.persistence.repository;

import com.ikwattro.egrid.persistence.DeviceChargingState;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceChargingStateRepository extends CrudRepository<DeviceChargingState, UUID> {

    @Modifying
    @Query(value = "UPDATE device_charging SET charging_level = ?1 WHERE device_id = ?2", nativeQuery = true)
    void updateChargingLevelForDevice(final int level, final UUID deviceId);
}
