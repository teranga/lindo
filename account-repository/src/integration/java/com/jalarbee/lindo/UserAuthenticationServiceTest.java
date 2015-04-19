package com.jalarbee.lindo;

import com.jalarbee.lindo.service.UserAuthenticationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

//import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Abdoulaye Diallo
 */

public class UserAuthenticationServiceTest extends LindowsApplicationTests {

    @Autowired private UserAuthenticationService userAuthenticationService;

    @Override
    public void setUp() {
        super.setUp();
        createUserAmina();
    }

    @Test
    public void authenticate() {
        UserDetails details = userAuthenticationService.loadUserByUsername("amina");
//        assertThat(details).isNotNull();
//        assertThat(details.getUsername()).isEqualTo("amina");
//        assertThat(details.getPassword()).isEqualTo("s3cr3t");
//        assertThat(details.getAuthorities()).hasSize(2);
    }
}
