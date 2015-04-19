package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.CassandraRepository;
import com.jalarbee.lindo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * @author Abdoulaye Diallo
 */
@Repository(value = "userDao")
public class UserDaoImpl extends CassandraRepository<User, MapId> implements UserDao {

    @Autowired private CassandraOperations cassandraOps;

    @Override
    protected CassandraOperations cassandraOps() {
        return cassandraOps;
    }

    @Override
    public User findByUsername(String username) {
        return cassandraOps.selectOne("select * from user where username = ?0", User.class);
    }

    @Override
    public Stream<User> findByFirstNameOrLastName(String firstName, String lastName) {
        return cassandraOps.select("select * from user where firstName = ?0 or lastName = ?1", User.class).stream();
    }
}
