package com.jalarbee.lindo.web.converter;

import com.datastax.driver.core.utils.UUIDs;
import com.jalarbee.lindo.dto.Procurement;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Abdoulaye Diallo
 */
public class ToDtoConverters {

    public static EntityDtoConverter<com.jalarbee.lindo.domain.procure.Procurement, Procurement> PROCUREMENT = (com.jalarbee.lindo.domain.procure.Procurement p) -> {
        Procurement procurement = new Procurement();
        procurement.setAmount(p.getAmount());
        procurement.setDateFrom(LocalDateTime.now()); //TODO: use correct date
        procurement.setDateTo(LocalDateTime.now());
        procurement.setId(UUIDs.timeBased());
        procurement.setOrganizationId(p.getOrganizationId());
        procurement.setOrganizationName(p.getOrganizationName());
//        procurement.setVouchers(p.getVouchers());
        procurement.setWithdrawn(p.getWithdrawn());
        procurement.setVouchersIssued(p.getVouchersIssued());
        procurement.setVouchersRedeemed(p.getVouchersRedeemed());
        procurement.setVouchersIssued(-1);
        return procurement;
    };
}
