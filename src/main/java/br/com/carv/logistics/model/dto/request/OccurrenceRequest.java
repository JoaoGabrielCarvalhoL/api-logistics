package br.com.carv.logistics.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OccurrenceRequest {

    @NotBlank @Size(max = 255, min = 5, message = "The field must have a minimum of {max} characters and a maximum of {min}")
    private String description;

    public OccurrenceRequest() {
    }

    public OccurrenceRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
