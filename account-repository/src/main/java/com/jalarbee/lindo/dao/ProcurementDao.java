package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.domain.procure.Procurement;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author Abdoulaye Diallo
 */
public interface ProcurementDao extends CrudRepository<Procurement, MapId> {

    Stream<Procurement> findAll(Date from, Date to);

    Procurement findOne(UUID organizationId, UUID id);

}
