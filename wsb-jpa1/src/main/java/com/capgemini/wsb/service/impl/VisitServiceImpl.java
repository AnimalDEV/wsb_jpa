package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VisitServiceImpl implements VisitService
{
    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao visitDao)
    {
        this.visitDao = visitDao;
    }

    @Override
    public VisitTO findById(Long id) {
        final VisitEntity entity = visitDao.findOne(id);
        return VisitMapper.mapToTO(entity);
    }

    @Override
    public List<VisitTO> findByPatientId(final Long patientId) {
        final List<VisitEntity> entities = visitDao.getByPatientId(patientId);
        return entities.stream().map(VisitMapper::mapToTO).collect(Collectors.toList());
    }
}
