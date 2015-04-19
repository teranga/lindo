package com.jalarbee.lindo.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Abdoulaye Diallo
 */


@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
public class User extends AbstractEntity {

    @PrimaryKey
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @NotNull
    private Set<String> roles = new HashSet<>();

}
