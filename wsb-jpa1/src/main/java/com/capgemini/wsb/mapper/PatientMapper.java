package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.stream.Collectors;

public final class PatientMapper
{

    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTo = new PatientTO();
        patientTo.setId(patientEntity.getId());
        patientTo.setFirstName(patientEntity.getFirstName());
        patientTo.setLastName(patientEntity.getLastName());
        patientTo.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTo.setEmail(patientEntity.getEmail());
        patientTo.setPatientNumber(patientEntity.getPatientNumber());
        patientTo.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTo.setAddress(
                AddressMapper.mapToTO(patientEntity.getAddress())
        );
        patientTo.setVisitsIds(
                patientEntity.getVisits().stream().map(VisitEntity::getId).collect(Collectors.toList())
        );
        patientTo.setHasInsurance(patientEntity.getHasInsurance());

        return patientTo;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTo)
    {
        if(patientTo == null)
        {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTo.getId());
        patientEntity.setFirstName(patientTo.getFirstName());
        patientEntity.setLastName(patientTo.getLastName());
        patientEntity.setTelephoneNumber(patientTo.getTelephoneNumber());
        patientEntity.setEmail(patientTo.getEmail());
        patientEntity.setPatientNumber(patientTo.getPatientNumber());
        patientEntity.setDateOfBirth(patientTo.getDateOfBirth());
        patientEntity.setAddress(
            AddressMapper.mapToEntity(patientTo.getAddress())
        );
        patientEntity.setHasInsurance(patientTo.getHasInsurance());

        return patientEntity;
    }
}
