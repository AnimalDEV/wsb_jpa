package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.dto.enums.DtoTreatmentType;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;

public final class MedicalTreatmentMapper
{

    public static MedicalTreatmentTO mapToTO(final MedicalTreatmentEntity medicalTreatmentEntity)
    {
        if (medicalTreatmentEntity == null)
        {
            return null;
        }

        final MedicalTreatmentTO medicalTreatmentTo = new MedicalTreatmentTO();
        medicalTreatmentTo.setId(medicalTreatmentEntity.getId());
        medicalTreatmentTo.setDescription(medicalTreatmentEntity.getDescription());
        medicalTreatmentTo.setType(
            MedicalTreatmentMapper.mapTreatmentTypeToDtoTreatmentType(medicalTreatmentEntity.getType())
        );

        return medicalTreatmentTo;
    }

    public static MedicalTreatmentEntity mapToEntity(final MedicalTreatmentTO medicalTreatmentTo)
    {
        if(medicalTreatmentTo == null)
        {
            return null;
        }

        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(medicalTreatmentTo.getId());
        medicalTreatmentEntity.setDescription(medicalTreatmentTo.getDescription());
        medicalTreatmentEntity.setType(
            MedicalTreatmentMapper.mapDtoTreatmentTypeToTreatmentType(medicalTreatmentTo.getType())
        );

        return medicalTreatmentEntity;
    }

    private static DtoTreatmentType mapTreatmentTypeToDtoTreatmentType(TreatmentType entityTreatmentType) {
        switch (entityTreatmentType) {
            case EKG:
                return DtoTreatmentType.EKG;
            case RTG:
                return DtoTreatmentType.RTG;
            case USG:
                return DtoTreatmentType.USG;
        }
        return null;
    }

    private static TreatmentType mapDtoTreatmentTypeToTreatmentType(DtoTreatmentType dtoTreatmentType) {
        switch (dtoTreatmentType) {
            case EKG:
                return TreatmentType.EKG;
            case RTG:
                return TreatmentType.RTG;
            case USG:
                return TreatmentType.USG;
        }
        return null;
    }
}
