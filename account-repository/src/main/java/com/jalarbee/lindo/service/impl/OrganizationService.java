package com.jalarbee.lindo.service.impl;

import com.datastax.driver.core.utils.UUIDs;
import com.jalarbee.lindo.dao.MembershipDao;
import com.jalarbee.lindo.dao.MembershipReviewDao;
import com.jalarbee.lindo.dao.OrganizationDao;
import com.jalarbee.lindo.domain.Membership;
import com.jalarbee.lindo.domain.Organization;
import com.jalarbee.lindo.domain.OrganizationReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Abdoulaye Diallo
 */

@Service
public class OrganizationService implements com.jalarbee.lindo.service.OrganizationService {

    @Autowired private OrganizationDao organizationDao;
    @Autowired private MembershipDao membershipDao;
    @Autowired private MembershipReviewDao membershipReviewDao;


    @Override
    public Organization create(String name, Date joinDate, Set<String> requiredFields, Map<String, String> rules) {
        Organization organization = Organization.builder()
                .name(name)
                .requiredFields(requiredFields != null ? requiredFields : new HashSet<String>())
                .rules(rules != null ? rules : new LinkedHashMap<String, String>())
                .joinDate(joinDate != null ? joinDate : new Date())
                .id(UUIDs.timeBased())
                .build();
        return organizationDao.save(organization);
    }

    @Override
    public List<OrganizationReview> getReviews(String organization) {
        return null;
    }

    @Override
    public List<Membership> getMemberships(String username) {
        return null;
    }

    @Override
    public Stream<Organization> findAll() {
        return StreamSupport.stream(organizationDao.findAll().spliterator(), false);
    }

    @Override
    public Organization getOrganization(UUID orgId) {
        return organizationDao.findOne(orgId);
    }

}
