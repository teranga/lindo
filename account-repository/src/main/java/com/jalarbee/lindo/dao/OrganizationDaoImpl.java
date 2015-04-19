package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.CassandraRepository;
import com.jalarbee.lindo.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */
@Repository("organizationDao")
public class OrganizationDaoImpl extends CassandraRepository<Organization, UUID> implements OrganizationDao  {


    @Autowired private CassandraOperations cassandraOps;

    @Override
    protected CassandraOperations cassandraOps() {
        return cassandraOps;
    }

    @Override
    public List<Organization> findByName(String name) {
        return cassandraOps.select("select * from organization where name = ?0", Organization.class);
    }
}
