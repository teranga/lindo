package com.jalarbee.lindo.service;

import com.jalarbee.lindo.domain.Membership;
import com.jalarbee.lindo.domain.Organization;
import com.jalarbee.lindo.domain.OrganizationReview;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Abdoulaye Diallo
 */
public interface OrganizationService {

    Organization create(String name, Date joinDate, Set<String> requiredFields, Map<String, String> rules);
    List<OrganizationReview> getReviews(String organization);
    List<Membership> getMemberships(String username);

    Stream<Organization> findAll();

    Organization getOrganization(UUID orgId);
}
