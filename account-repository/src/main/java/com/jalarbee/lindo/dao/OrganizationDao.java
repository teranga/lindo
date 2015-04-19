package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.domain.Organization;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */

public interface OrganizationDao extends CrudRepository<Organization, UUID> {

    List<Organization> findByName(String name);
}
