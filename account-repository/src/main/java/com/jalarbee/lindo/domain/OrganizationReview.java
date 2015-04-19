package com.jalarbee.lindo.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class OrganizationReview extends AbstractEntity {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String organization;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID reviewDate;

    @Column
    private String reviewer;

    @Column
    private String review;

    @Column
    private int rating;
}
