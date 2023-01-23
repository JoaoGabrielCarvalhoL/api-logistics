package br.com.carv.logistics.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionHandlerResponse {

    private LocalDateTime timestamp;
    private String details;
    private Integer status;
    private String title;

    private List<FieldErrorResponse> errors;

    public ExceptionHandlerResponse() {
    }

    public ExceptionHandlerResponse(LocalDateTime timestamp, String details, Integer status, String title, List<FieldErrorResponse> errors) {
        this.timestamp = timestamp;
        this.details = details;
        this.status = status;
        this.title = title;
        this.errors = errors;
    }

    public ExceptionHandlerResponse(LocalDateTime timestamp, String details, Integer status, String title) {
        this.timestamp = timestamp;
        this.details = details;
        this.status = status;
        this.title = title;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FieldErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldErrorResponse> errors) {
        this.errors = errors;
    }
}
