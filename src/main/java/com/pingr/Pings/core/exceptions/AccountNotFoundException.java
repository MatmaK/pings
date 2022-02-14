package com.pingr.Pings.core.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("One or all accounts not found");
    }
    public AccountNotFoundException(Long id) {
        super("Account not found: [id: " + id + "]");
    }

    public AccountNotFoundException(Long id, Throwable cause) {
        super("Account not found: [id: " + id + "]", cause);
    }
}