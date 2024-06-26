package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest
{
    @Autowired
    private AddressDao addressDao;

    @Transactional
    @Test
    public void testShouldFindAddressById() {
        // given
        // when
        AddressEntity addressEntity = addressDao.findOne(1L);
        // then
        Assertions.assertThat(addressEntity).isNotNull();
        Assertions.assertThat(addressEntity.getPostalCode()).isEqualTo("62-030");
    }

    @Test
    public void testShouldSaveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");
        long entitiesNumBefore = addressDao.count();

        // when
        final AddressEntity saved = addressDao.save(addressEntity);

        // then
        Assertions.assertThat(saved).isNotNull();
        Assertions.assertThat(saved.getId()).isNotNull();
        Assertions.assertThat(addressDao.count()).isEqualTo(entitiesNumBefore+1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");

        // when
        final AddressEntity saved = addressDao.save(addressEntity);
        Assertions.assertThat(saved.getId()).isNotNull();
        final AddressEntity newSaved = addressDao.findOne(saved.getId());
        Assertions.assertThat(newSaved).isNotNull();

        addressDao.delete(saved.getId());

        // then
        final AddressEntity removed = addressDao.findOne(saved.getId());
        Assertions.assertThat(removed).isNull();
    }


}
