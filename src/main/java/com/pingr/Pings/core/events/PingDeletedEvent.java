package com.pingr.Pings.core.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pingr.Pings.core.Pings.Ping;

import java.util.Map;

@JsonSerialize
public class PingDeletedEvent {
    @JsonProperty
    private String eventType;

    @JsonProperty
    private Long pingId;

    @JsonProperty
    private Map<String, Object> payload;

    public PingDeletedEvent(String eventType, Long pingId, Map<String, Object> payload) {
        this.eventType = eventType;
        this.pingId = pingId;
        this.payload = payload;
    }

    public static PingDeletedEvent of(Ping ping) {
        return new PingDeletedEvent(
                "PingDeletedEvent",
                ping.getId(),
                ping.toMapWithoutBody()
        );
    }
}
