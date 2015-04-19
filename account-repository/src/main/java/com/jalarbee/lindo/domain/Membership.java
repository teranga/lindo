package com.jalarbee.lindo.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

/**
 * @author Abdoulaye Diallo
 */

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
public class Membership extends AbstractEntity {

    @PrimaryKeyColumn(name = "username", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String username;

    @PrimaryKeyColumn(name = "organization", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private String organization;

    @Column
    private String role;

    @Column
    private int liked;

    @Column
    private int disliked;

    @Column
    private double rating;

}
