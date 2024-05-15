package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;
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
public class VisitServiceTest
{

    @Autowired
    private VisitService visitService;

    @Transactional
    @Test
    public void testShouldReturnPatientVisits() {
        // given
        Long patientId = 2L;
        // when
        List<VisitTO> visits = visitService.findByPatientId(patientId);
        // then
        Assertions.assertThat(visits.size()).isEqualTo(1);
    }
}
