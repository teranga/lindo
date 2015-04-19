package com.jalarbee.lindo.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Date;
import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
public class VoucherRedemption extends AbstractEntity {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private UUID organization;
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private UUID engagement;
    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID voucher;

    @Column
    private Date redemptionDate;
    @Column
    private String redeemerName;
    @Column
    private String redeemerId;
    @Column
    private String redeemerIdType;


}
