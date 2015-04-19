package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.domain.UserReview;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * @author Abdoulaye Diallo
 */
public interface MembershipReviewDao extends CassandraRepository<UserReview> {


}
