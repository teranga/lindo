package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.domain.Membership;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

/**
 * @author Abdoulaye Diallo
 */
public interface MembershipDao extends CassandraRepository<Membership> {

    @Query("select * from membership where usnername = ?0")
    List<Membership> findByUsername(String username);
}
