package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private VisitDao visitDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientService patientService;

    @Transactional
    @Test
    public void testShouldDeletePatient() {
        // given
        Long id = 1L;
        // when
        patientService.deleteById(id);
        // then
        Assertions.assertThat(patientDao.findOne(id)).isNull();
        //Assertions.assertThat(addressEntity.getPostalCode()).isEqualTo("62-030");
    }

    @Transactional
    @Test
    public void testShouldDeletePatientVisits() {
        // given
        Long id = 1L;
        PatientEntity patientEntity = patientDao.findOne(id);
        // when
        patientService.deleteById(id);
        // then
        patientEntity.getVisits().forEach((visit) -> Assertions.assertThat(visitDao.findOne(visit.getId())).isNull());
    }

    @Transactional
    @Test
    public void testShouldNotDeleteVisitsDoctors() {
        // given
        Long id = 1L;
        PatientEntity patientEntity = patientDao.findOne(id);
        // when
        patientService.deleteById(id);
        // then
        patientEntity.getVisits().forEach((visit) -> Assertions.assertThat(doctorDao.findOne(visit.getDoctor().getId())).isNotNull());
    }

    @Transactional
    @Test
    public void testShouldReturnProperPatientStructure() {
        // given
        Long id = 1L;
        PatientEntity patientEntity = patientDao.findOne(id);

        AddressTO expectedAddressTo = new AddressTO();
        expectedAddressTo.setId(patientEntity.getAddress().getId());
        expectedAddressTo.setCity(patientEntity.getAddress().getCity());
        expectedAddressTo.setAddressLine1(patientEntity.getAddress().getAddressLine1());
        expectedAddressTo.setAddressLine2(patientEntity.getAddress().getAddressLine2());
        expectedAddressTo.setPostalCode(patientEntity.getAddress().getPostalCode());

        PatientTO expectedPatientTo = new PatientTO();
        expectedPatientTo.setId(patientEntity.getId());
        expectedPatientTo.setFirstName(patientEntity.getFirstName());
        expectedPatientTo.setLastName(patientEntity.getLastName());
        expectedPatientTo.setTelephoneNumber(patientEntity.getTelephoneNumber());
        expectedPatientTo.setEmail(patientEntity.getEmail());
        expectedPatientTo.setPatientNumber(patientEntity.getPatientNumber());
        expectedPatientTo.setDateOfBirth(patientEntity.getDateOfBirth());
        expectedPatientTo.setAddress(expectedAddressTo);
        expectedPatientTo.setHasInsurance(patientEntity.getHasInsurance());
        expectedPatientTo.setVisitsIds(patientEntity.getVisits().stream().map(VisitEntity::getId).collect(Collectors.toList()));

        // when
        PatientTO patientTo = patientService.findById(id);

        // then
        Assertions.assertThat(patientTo).usingRecursiveComparison().isEqualTo(expectedPatientTo);
    }
}
