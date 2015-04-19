package com.jalarbee.lindo;


import com.google.common.collect.Sets;
import com.jalarbee.lindo.domain.*;
import com.jalarbee.lindo.domain.procure.Procurement;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.data.cassandra.core.CassandraOperations;

import java.util.HashMap;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestConfig.class, CassandraConfiguration.class})
public abstract class LindowsApplicationTests {

    @Autowired
    private CassandraAdminOperations adminOperations;
    @Autowired private CassandraOperations operations;

    @Before
    public void setUp() {
        resetKeySpace();
    }

    @After
    public void tearDown() {

    }

    protected void resetKeySpace() {

        adminOperations.dropTable(CqlIdentifier.cqlId(User.class.getSimpleName().toLowerCase()));
        adminOperations.dropTable(CqlIdentifier.cqlId(UserEvent.class.getSimpleName().toLowerCase()));
        adminOperations.dropTable(CqlIdentifier.cqlId(Organization.class.getSimpleName().toLowerCase()));
        adminOperations.dropTable(CqlIdentifier.cqlId(Membership.class.getSimpleName().toLowerCase()));
        adminOperations.dropTable(CqlIdentifier.cqlId(UserReview.class.getSimpleName().toLowerCase()));
        adminOperations.dropTable(CqlIdentifier.cqlId(OrganizationReview.class.getSimpleName().toLowerCase()));
        adminOperations.dropTable(CqlIdentifier.cqlId(Procurement.class.getSimpleName().toLowerCase()));
        adminOperations.dropTable(CqlIdentifier.cqlId(VoucherRedemption.class.getSimpleName().toLowerCase()));
        adminOperations.dropTable(CqlIdentifier.cqlId(Client.class.getSimpleName().toLowerCase()));


        adminOperations.createTable(true, CqlIdentifier.cqlId(User.class.getSimpleName().toLowerCase()), User.class, new HashMap<>());
        adminOperations.createTable(true, CqlIdentifier.cqlId(UserEvent.class.getSimpleName().toLowerCase()), UserEvent.class, new HashMap<>());
        adminOperations.createTable(true, CqlIdentifier.cqlId(Organization.class.getSimpleName().toLowerCase()), Organization.class, new HashMap<>());
        adminOperations.createTable(true, CqlIdentifier.cqlId(Membership.class.getSimpleName().toLowerCase()), Membership.class, new HashMap<>());
        adminOperations.createTable(true, CqlIdentifier.cqlId(UserReview.class.getSimpleName().toLowerCase()), UserReview.class, new HashMap<>());
        adminOperations.createTable(true, CqlIdentifier.cqlId(OrganizationReview.class.getSimpleName().toLowerCase()), OrganizationReview.class, new HashMap<>());
        adminOperations.createTable(true, CqlIdentifier.cqlId(Procurement.class.getSimpleName().toLowerCase()), Procurement.class, new HashMap<>());
        adminOperations.createTable(true, CqlIdentifier.cqlId(VoucherRedemption.class.getSimpleName().toLowerCase()), VoucherRedemption.class, new HashMap<>());
        adminOperations.createTable(true, CqlIdentifier.cqlId(Client.class.getSimpleName().toLowerCase()), Client.class, new HashMap<>());
    }


    protected Organization findJavaLove() {
        return operations.selectOne("select * from organization where id=\"84693b80-e0bc-11e4-a0b9-a914f251ba26\"", Organization.class);
    }

    protected void createUserAmina() {
        User amina = User.builder().firstName("Amina")
                .lastName("Diallo")
                .username("amina")
                .password("s3cr3t")
                .roles(Sets.newHashSet("ADMIN", "CLERK"))
                .build();
        operations.insert(amina);
    }

}

@Configuration
@ComponentScan
class TestConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestConfig.class);

    @Autowired private transient Environment environment;
    @Autowired private transient CassandraConfiguration cassandraConfiguration;
}
