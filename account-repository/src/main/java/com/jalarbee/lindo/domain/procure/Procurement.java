package com.jalarbee.lindo.domain.procure;

import com.jalarbee.lindo.domain.AbstractEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
public class Procurement extends AbstractEntity {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private UUID organizationId;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID id;

    @Column
    private String organizationName;

    @Column
    private Date dateFrom;

    @Column
    private Date dateTo;

    @Column
    private String status;

    @Column
    private BigDecimal amount;

    @Column
    private BigDecimal withdrawn;

    @Column
    private int vouchersIssued;

    @Column
    private int vouchersRedeemed;

    @Column
    private Map<BigDecimal, Integer> vouchers = new HashMap<>();


}
