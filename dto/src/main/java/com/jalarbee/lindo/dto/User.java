package com.jalarbee.lindo.dto;


import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * <p>this class serves as a transport object for user related information.</p>
 *
 * <p>Validation rules:
 * <ul>
 *     <li>username: string must be between {@value #USER_NAME_MIN} and {@value User#USER_NAME_MAX}</li>
 *     <li>password: string must be between {@value User#PASSWORD_MIN} and {@value User#PASSWORD_MAX}</li>
 *     <li>email: must have valid email format or be <code>null</code></li>
 * </ul>
 */

@EqualsAndHashCode(of = {"username"})
@Data
@NoArgsConstructor
public final class User {

    public static final int USER_NAME_MIN = 3;
    public static final int USER_NAME_MAX = 15;

    public static final int PASSWORD_MIN = 6;
    public static final int PASSWORD_MAX = 15;

    @NotEmpty
    @Size(min = USER_NAME_MIN, max = USER_NAME_MAX)
    private String username;

    @Size(min = PASSWORD_MIN, max = PASSWORD_MAX)
    private String password;

    private String firstname;
    private String lastname;

    private String phone;

    @Email
    @Null
    private String email;


}
