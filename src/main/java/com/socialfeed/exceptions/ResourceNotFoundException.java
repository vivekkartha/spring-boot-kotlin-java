package com.socialfeed.exceptions;

import org.hibernate.HibernateException;

public class ResourceNotFoundException extends HibernateException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
