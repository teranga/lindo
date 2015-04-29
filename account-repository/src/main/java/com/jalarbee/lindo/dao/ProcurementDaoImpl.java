package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.CassandraRepository;
import com.jalarbee.lindo.domain.procure.Procurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author Abdoulaye Diallo
 */
@Repository("cassandraOperations")
public class ProcurementDaoImpl extends CassandraRepository<Procurement, MapId> implements ProcurementDao {

    @Autowired private CassandraOperations cassandraOperations;

    @Override
    protected CassandraOperations cassandraOps() {
        return cassandraOperations;
    }

    @Override
    public Stream<Procurement> findAll(Date from, Date to) {
        return cassandraOperations.select("", Procurement.class).stream(); //TODO implement me
    }

    @Override
    public Procurement findOne(UUID organizationId, UUID id) {
        return cassandraOperations.selectOne("", Procurement.class); //TODO implement me
    }
}
