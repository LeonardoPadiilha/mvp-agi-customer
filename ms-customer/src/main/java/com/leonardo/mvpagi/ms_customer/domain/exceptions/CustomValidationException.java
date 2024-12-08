package com.leonardo.mvpagi.ms_customer.domain.exceptions;

import static java.lang.String.format;

public class CustomValidationException extends RuntimeException {
    private final String field;
    private final String message;

    public CustomValidationException(final String field, final String message) {
        super(message);
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    @Override
    public String getMessage() {
        return format("{0} {1}", field, message);
    }

    public static CustomValidationException of(final String field, final String message) {
        return new CustomValidationException(field, message);
    }
}
