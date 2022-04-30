package com.ikwattro.egrid.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikwattro.egrid.DeviceEvent;
import com.ikwattro.egrid.domain.GeneratedDeviceEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class EventEndpointController {

    private static final ObjectMapper OM = new ObjectMapper();

    @PostMapping("/events/device/{id}")
    public void deviceEventEndpoint(@PathVariable String id, @RequestBody String s) {
        Stream<String> lines = s.lines();
        lines.forEach(l -> {
            try {
                GeneratedDeviceEvent ev = OM.readValue(l, GeneratedDeviceEvent.class);
                DeviceEvent deviceEvent = new DeviceEvent(ev.getDevice_id(), ev.getCharging_source(), ev.getCurrent_capacity());
                System.out.println(deviceEvent.getChargingSource());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
