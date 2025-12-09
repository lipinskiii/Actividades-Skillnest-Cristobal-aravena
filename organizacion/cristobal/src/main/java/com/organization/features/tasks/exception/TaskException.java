package com.organization.features.tasks;

import com.organization.core.AppException;

public class TaskException extends AppException {
    public TaskException(String message) {
        super(message);
    }

    public TaskException(String message, Throwable cause) {
        super(message, cause);
    }
}
