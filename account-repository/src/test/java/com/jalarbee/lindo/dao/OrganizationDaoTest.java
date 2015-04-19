package com.jalarbee.lindo.dao;

import com.datastax.driver.core.utils.UUIDs;
import com.jalarbee.lindo.BaseAccountTest;
import com.jalarbee.lindo.domain.Organization;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Abdoulaye Diallo
 */

public class OrganizationDaoTest extends BaseAccountTest {

    @Autowired private OrganizationDao organizationDao;

    @Test
    public void createOrg() {
        Organization myorg = Organization.builder()
                .id(UUIDs.timeBased())
                .joinDate(new Date())
                .name("Scala Love")
                .requiredFields(new HashSet<String>() {{ add("username"); add("password"); add("phone");}})
                .rules(new HashMap<String, String>(){{put("rule#1", "be nice!"); put("rule#2", "be helpful"); put("rule#3", "be productive");}})
                .build();
        organizationDao.save(myorg);
    }

}
