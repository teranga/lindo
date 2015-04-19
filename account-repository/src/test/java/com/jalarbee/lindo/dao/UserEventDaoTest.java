package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.BaseAccountTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Abdoulaye Diallo
 */
public class UserEventDaoTest extends BaseAccountTest {

    @Autowired private UserEventDao userEventDao;

    @Test
    public void getUserEvents() {
        userEventDao.save(createLoginEvent());
        userEventDao.save(createLogoutEvent());
        assertThat(userEventDao.count()).isEqualTo(2);
    }
}
