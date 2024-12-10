package com.leonardo.mvpagi.ms_customer.domain.exceptions;

import lombok.Getter;

import static java.lang.String.format;


public class NotFoundException extends RuntimeException {
    private static final String DEFAULT_MSG = "not found";

    private String resource;


    public NotFoundException(String resource) {
        super(DEFAULT_MSG);
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    @Override
    public String getMessage() {
        return format("%s %s", resource, DEFAULT_MSG);
    }

    public static NotFoundException of(final String resource) {
        return new NotFoundException(resource);
    }


}
