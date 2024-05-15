package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        // given
        String lastName = "Remer";
        // when
        List<PatientEntity> patientsEntities = patientDao.getByLastName(lastName);
        // then
        Assertions.assertThat(patientsEntities.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void testShouldReturnPatientsWithMoreVisitsThanSpecified() {
        // given
        Integer numberOfVisits = 1;

        // when
        List<PatientEntity> patientsEntities = patientDao.getPatientWithMoreVisitsThan(numberOfVisits);
        // then
        Assertions.assertThat(patientsEntities.size()).isGreaterThan(0);

        patientsEntities.forEach((patientEntity) -> Assertions.assertThat(patientEntity.getVisits().size()).isGreaterThan(numberOfVisits));
    }

    @Transactional
    @Test
    public void testShouldReturnPatientsWithInsurance() {
        // given
        // when
        List<PatientEntity> patientsEntities = patientDao.getByHasInsurance(true);
        // then
        patientsEntities.forEach((patientEntity) -> Assertions.assertThat(patientEntity.getHasInsurance()).isEqualTo(true));
    }
}
