package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface VisitService
{
    VisitTO findById(final Long id);

    List<VisitTO> findByPatientId(final Long patientId);
}
