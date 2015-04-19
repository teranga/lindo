package com.jalarbee.lindo;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.Sets;
import com.jalarbee.lindo.domain.EventType;
import com.jalarbee.lindo.domain.Organization;
import com.jalarbee.lindo.domain.User;
import com.jalarbee.lindo.domain.UserEvent;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */
public class BaseAccountTest extends BaseUnitTest {

    protected Organization createOrgJavaLove() {
        return Organization.builder()
                .joinDate(new Date())
                .name("Java Love")
                .id(UUID.fromString("84693b80-e0bc-11e4-a0b9-a914f251ba26"))
                .requiredFields(new HashSet<String>() {{
                    add("username");
                    add("password");
                    add("phone");
                }})
                .rules(new HashMap<String, String>() {{
                    put("rule#1", "be nice!");
                    put("rule#2", "be helpful");
                    put("rule#3", "be productive");
                }})
                .build();
    }

    protected UserEvent createLoginEvent() {
        return UserEvent.builder()
                .eventDate(UUIDs.timeBased())
                .username("amina")
                .type(EventType.LOGIN.name())
                .payload(new HashMap<String, ByteBuffer>() {{
                    put("hello", ByteBuffer.wrap("World".getBytes(Charset.forName("UTF-8"))));
                }})
                .build();
    }

    protected UserEvent createLogoutEvent() {
        return UserEvent.builder()
                .eventDate(UUIDs.timeBased())
                .username("amina")
                .type(EventType.LOGOUT.name())
                .payload(new HashMap<String, ByteBuffer>() {{
                    put("hello", ByteBuffer.wrap("World".getBytes(Charset.forName("UTF-8"))));
                }})
                .build();
    }

    protected User createUserAmina() {
        return User.builder().firstName("Amina")
                .lastName("Diallo")
                .username("amina")
                .password("s3cr3t")
                .roles(Sets.newHashSet("ADMIN", "CLERK"))
                .build();
    }
}
