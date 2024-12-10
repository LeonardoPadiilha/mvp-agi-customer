package com.leonardo.mvpagi.ms_insurance.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"headers", "titleMessageCode", "detailMessageCode", "typeMessageCode"})
public class DefaultErrorResponse implements ErrorResponse {

    private String message;
    private String field;

    public DefaultErrorResponse() {
    }

    public DefaultErrorResponse(String message, String field) {
        this.message = message;
        this.field = field;
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return null;
    }

    @Override
    public ProblemDetail getBody() {
        return null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
