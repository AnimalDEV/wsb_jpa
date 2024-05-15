package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.enums.DtoSpecialization;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.Specialization;

import java.util.stream.Collectors;

public final class DoctorMapper
{

    public static DoctorTO mapToTO(final DoctorEntity doctorEntity)
    {
        if (doctorEntity == null)
        {
            return null;
        }

        final DoctorTO doctorTo = new DoctorTO();
        doctorTo.setId(doctorEntity.getId());
        doctorTo.setFirstName(doctorEntity.getFirstName());
        doctorTo.setLastName(doctorEntity.getLastName());
        doctorTo.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTo.setEmail(doctorEntity.getEmail());
        doctorTo.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTo.setSpecialization(
            DoctorMapper.mapSpecializationToDtoSpecialization(doctorEntity.getSpecialization())
        );
        doctorTo.setAddress(
            AddressMapper.mapToTO(doctorEntity.getAddress())
        );
        doctorTo.setVisitsIds(
            doctorEntity.getVisits().stream().map(VisitEntity::getId).collect(Collectors.toList())
        );

        return doctorTo;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTo)
    {
        if(doctorTo == null)
        {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTo.getId());
        doctorEntity.setFirstName(doctorTo.getFirstName());
        doctorEntity.setLastName(doctorTo.getLastName());
        doctorEntity.setTelephoneNumber(doctorTo.getTelephoneNumber());
        doctorEntity.setEmail(doctorTo.getEmail());
        doctorEntity.setDoctorNumber(doctorTo.getDoctorNumber());
        doctorEntity.setAddress(
            AddressMapper.mapToEntity(doctorTo.getAddress())
        );

        return doctorEntity;
    }


    private static DtoSpecialization mapSpecializationToDtoSpecialization(Specialization entitySpecialization) {
        switch (entitySpecialization) {
            case GP:
                return DtoSpecialization.GP;
            case OCULIST:
                return DtoSpecialization.OCULIST;
            case SURGEON:
                return DtoSpecialization.SURGEON;
            case DERMATOLOGIST:
                return DtoSpecialization.DERMATOLOGIST;
        }
        return null;
    }

    private static Specialization mapDtoSpecializationToSpecialization(DtoSpecialization dtoSpecialization) {
        switch (dtoSpecialization) {
            case GP:
                return Specialization.GP;
            case OCULIST:
                return Specialization.OCULIST;
            case SURGEON:
                return Specialization.SURGEON;
            case DERMATOLOGIST:
                return Specialization.DERMATOLOGIST;
        }
        return null;
    }
}
