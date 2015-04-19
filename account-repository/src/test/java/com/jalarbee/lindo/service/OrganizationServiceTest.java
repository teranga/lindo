package com.jalarbee.lindo.service;

import com.jalarbee.lindo.BaseAccountTest;
import com.jalarbee.lindo.domain.Organization;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Abdoulaye Diallo
 */

public class OrganizationServiceTest extends BaseAccountTest {

    @Autowired private OrganizationService organizationService;

    @Test
    public void createOrg() {
        Organization organization = organizationService.create("Iam amI", new Date(), null, null);
        Assertions.assertThat(organization).isNotNull();
        Assertions.assertThat(organization.getName()).isEqualTo("Iam amI");
    }
}
