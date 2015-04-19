package com.jalarbee.lindo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */
@EqualsAndHashCode(of = {"organizationId", "dateFrom", "dateTo", "amount"})
@Data
@NoArgsConstructor
public class Procurement {

    private UUID organizationId;

    private String organizationName;

    private UUID id;

    private Status status;

    private LocalDateTime dateFrom;

    private LocalDateTime dateTo;

    private BigDecimal amount;

    private BigDecimal withdrawn;

    private int vouchersIssued;

    private int vouchersRedeemed;

    private Map<BigDecimal, Short> vouchers = new HashMap<>();

    public static enum Status {
        IN_PROGRESS, CLOSED, LONG_RUNNING
    }
}
