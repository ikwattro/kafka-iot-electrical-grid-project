package com.ikwattro.egrid.service;

import com.ikwattro.egrid.DeviceEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventsProducer {

    private static final String DEVICE_EVENTS_TOPIC = "device-events";

    private final KafkaTemplate<String, DeviceEvent> kafkaTemplate;

    public EventsProducer(KafkaTemplate<String, DeviceEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendDeviceEvent(DeviceEvent deviceEvent) {
        this.kafkaTemplate.send(DEVICE_EVENTS_TOPIC, deviceEvent.getDeviceId(), deviceEvent);
    }
}
