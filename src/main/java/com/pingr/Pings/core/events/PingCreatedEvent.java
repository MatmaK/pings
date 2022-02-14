package com.pingr.Pings.core.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pingr.Pings.core.Pings.Ping;

import java.util.Map;

@JsonSerialize
public class PingCreatedEvent {
    @JsonProperty
    private String eventType;

    @JsonProperty
    private Long pingId;

    @JsonProperty
    private Map<String, Object> payload;

    public PingCreatedEvent(String eventType, Long pingId, Map<String, Object> payload) {
        this.eventType = eventType;
        this.pingId = pingId;
        this.payload = payload;
    }

    public static PingCreatedEvent of(Ping ping) {
        return new PingCreatedEvent(
                "PingCreatedEvent",
                ping.getId(),
                ping.toMap()
        );
    }
}
