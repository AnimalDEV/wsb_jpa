package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    List<PatientEntity> getByLastName(final String lastName);

    List<PatientEntity> getPatientWithMoreVisitsThan(final Integer numberOfVisits);

    List<PatientEntity> getByHasInsurance(final Boolean hasInsurance);
}
