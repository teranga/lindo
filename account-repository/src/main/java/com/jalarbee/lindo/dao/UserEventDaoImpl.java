package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.CassandraRepository;
import com.jalarbee.lindo.domain.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Repository;

/**
 * @author Abdoulaye Diallo
 */
@Repository("userEventDao")
public class UserEventDaoImpl extends CassandraRepository<UserEvent, MapId> implements UserEventDao {

    @Autowired private CassandraOperations cassandraOperations;

    @Override
    protected CassandraOperations cassandraOps() {
        return cassandraOperations;
    }
}
