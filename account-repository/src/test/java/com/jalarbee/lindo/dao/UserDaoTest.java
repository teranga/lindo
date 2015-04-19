package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.BaseAccountTest;
import com.jalarbee.lindo.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Abdoulaye Diallo
 */


public class UserDaoTest extends BaseAccountTest {

    @Autowired UserDao userDao;

    @Test
    public void createUser() {
        User amina = userDao.save(createUserAmina());
        assertThat(amina).isNotNull();
        assertThat(amina.getUsername()).isEqualTo("amina");
        assertThat(amina.getRoles()).hasSize(2);
        assertThat(amina.getRoles()).contains("CLERK");
    }

}
