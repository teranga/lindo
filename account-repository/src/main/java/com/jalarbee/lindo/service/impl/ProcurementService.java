package com.jalarbee.lindo.service.impl;

import com.jalarbee.lindo.dao.ProcurementDao;
import com.jalarbee.lindo.domain.procure.Procurement;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.cassandra.repository.support.BasicMapId.id;
import org.springframework.data.cassandra.repository.support.MapIdFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Abdoulaye Diallo
 */

@Service
public class ProcurementService implements com.jalarbee.lindo.service.procure.ProcurementService {

    @Autowired
    private ProcurementDao procurementDao;

    @Override
    public Procurement create(Procurement procurement) {
        return procurementDao.save(procurement);
    }

    @Override
    public Stream<Procurement> findProcurements(UUID organizationId) {
        return StreamSupport.stream(procurementDao.findAll(Collections.singleton(id("organizationId", organizationId))).spliterator(), false);
    }

    @Override
    public Procurement findProcurement(UUID organizationId, UUID id) {
        return procurementDao.findOne(organizationId, id);
    }
}
