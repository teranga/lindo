package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.domain.User;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

/**
 * @author Abdoulaye Diallo
 */

public interface UserDao extends CrudRepository<User, MapId> {

    User findByUsername(final String username);

    Stream<User> findByFirstNameOrLastName(final String firstName, final String lastName);

}
