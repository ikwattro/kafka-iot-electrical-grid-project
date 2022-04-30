package com.ikwattro.egrid.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneratedDeviceEvent {

    private String charging_source;
    private String device_id;
    private int current_capacity;
}
