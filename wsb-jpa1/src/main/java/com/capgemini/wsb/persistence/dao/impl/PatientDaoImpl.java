package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    public List<PatientEntity> getByLastName(final String lastName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> criteriaQuery = builder.createQuery(getDomainClass());
        Root<PatientEntity> root = criteriaQuery.from(getDomainClass());

        criteriaQuery.select(root).where(builder.equal(root.get("lastName"), lastName));

        TypedQuery<PatientEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<PatientEntity> getPatientWithMoreVisitsThan(final Integer numberOfVisits) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> criteriaQuery = builder.createQuery(PatientEntity.class);
        Root<PatientEntity> patientRoot = criteriaQuery.from(PatientEntity.class);
        Join<PatientEntity, VisitEntity> visitJoin = patientRoot.join("visits", JoinType.LEFT);

        // Count the number of visits for each patient
        Expression<Long> patientVisitsCount = builder.count(visitJoin.get("id"));

        // Select patients with more than the specified number of visits
        criteriaQuery.select(patientRoot)
                .groupBy(patientRoot.get("id"))
                .having(builder.gt(patientVisitsCount, numberOfVisits));

        TypedQuery<PatientEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<PatientEntity> getByHasInsurance(final Boolean hasInsurance) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> criteriaQuery = builder.createQuery(getDomainClass());
        Root<PatientEntity> root = criteriaQuery.from(getDomainClass());

        criteriaQuery.select(root).where(builder.equal(root.get("hasInsurance"), hasInsurance));

        TypedQuery<PatientEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
