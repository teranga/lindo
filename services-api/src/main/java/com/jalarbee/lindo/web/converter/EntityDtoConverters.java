package com.jalarbee.lindo.web.converter;

import com.jalarbee.lindo.domain.Organization;

import java.time.LocalDateTime;

/**
 * Created by diallo on 3/31/15.
 */
public class EntityDtoConverters {

    private EntityDtoConverters() {
    }

    public static final OrganizationConverter ORGANIZATION_CONVERTER = new OrganizationConverter();

    public static class OrganizationConverter implements EntityDtoConverter<Organization, com.jalarbee.lindo.dto.Organization> {

        @Override
        public com.jalarbee.lindo.dto.Organization convert(Organization entity) {
            com.jalarbee.lindo.dto.Organization org = new com.jalarbee.lindo.dto.Organization();
            org.setName(entity.getName());
            org.setJoinDate(LocalDateTime.now()); //TODO: convert the real date
            org.setRequiredFields(entity.getRequiredFields());
            org.setRules(entity.getRules());
            return org;
        }
    }
}




