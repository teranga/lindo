package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.domain.UserEvent;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Abdoulaye Diallo
 */
public interface UserEventDao extends CrudRepository<UserEvent, MapId> {

}
