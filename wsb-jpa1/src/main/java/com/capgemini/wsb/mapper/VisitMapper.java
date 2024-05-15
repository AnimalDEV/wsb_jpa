package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.stream.Collectors;

public final class VisitMapper
{

    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }

        final VisitTO visitTo = new VisitTO();
        visitTo.setId(visitEntity.getId());
        visitTo.setDescription(visitEntity.getDescription());
        visitTo.setDoctor(
            DoctorMapper.mapToTO(visitEntity.getDoctor())
        );
        visitTo.setPatient(
            PatientMapper.mapToTO(visitEntity.getPatient())
        );
        visitTo.setMedicalTreatments(
            visitEntity
                .getMedicalTreatments()
                .stream()
                .map(MedicalTreatmentMapper::mapToTO)
                .collect(Collectors.toList())
        );
        return visitTo;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTo)
    {
        if(visitTo == null)
        {
            return null;
        }

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTo.getId());
        visitEntity.setDescription(visitTo.getDescription());
        visitEntity.setDoctor(
            DoctorMapper.mapToEntity(visitTo.getDoctor())
        );
        visitEntity.setPatient(
            PatientMapper.mapToEntity(visitTo.getPatient())
        );

        return visitEntity;
    }
}
