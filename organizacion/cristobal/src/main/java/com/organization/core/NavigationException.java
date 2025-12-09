package com.organization.core;

public class NavigationException extends AppException {
    public NavigationException(String message) {
        super(message);
    }

    public NavigationException(String message, Throwable cause) {
        super(message, cause);
    }
}
