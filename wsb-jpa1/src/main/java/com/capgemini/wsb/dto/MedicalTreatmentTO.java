package com.capgemini.wsb.dto;

import com.capgemini.wsb.dto.enums.DtoTreatmentType;

import java.io.Serializable;

public class MedicalTreatmentTO implements Serializable
{
    private Long id;

    private String description;

    private DtoTreatmentType type;

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

    public DtoTreatmentType getType() {
        return type;
    }

    public void setType(DtoTreatmentType type) {
        this.type = type;
    }
}
