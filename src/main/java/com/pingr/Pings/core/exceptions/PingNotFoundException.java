package com.pingr.Pings.core.exceptions;

public class PingNotFoundException extends RuntimeException {

    public PingNotFoundException(Long id) {
        super("Ping not found: [id: " + id + "]");
    }

    public PingNotFoundException(Long id, Throwable cause) {
        super("Ping not found: [id: " + id + "]", cause);
    }
}