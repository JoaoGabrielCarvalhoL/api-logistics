package br.com.carv.logistics.model.dto.response;

import java.time.LocalDate;

public class OccurrenceResponse {

    private Long id;
    private String description;
    private LocalDate registryDate;

    public OccurrenceResponse() {
    }
    public OccurrenceResponse(Long id, String description, LocalDate registryDate) {
        this.id = id;
        this.description = description;
        this.registryDate = registryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(LocalDate registryDate) {
        this.registryDate = registryDate;
    }
}
