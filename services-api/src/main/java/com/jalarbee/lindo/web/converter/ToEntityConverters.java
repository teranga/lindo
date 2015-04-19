package com.jalarbee.lindo.web.converter;

import com.jalarbee.lindo.dto.Procurement;

import java.util.Date;

/**
 * @author Abdoulaye Diallo
 */
public class ToEntityConverters {


    public static DtoEntityConverter<Procurement, com.jalarbee.lindo.domain.procure.Procurement> PROCUREMENT = (Procurement p) -> com.jalarbee.lindo.domain.procure.Procurement.builder()
            .amount(p.getAmount())
            .dateFrom(new Date())//TODO: use correct date
            .dateTo(new Date())
            .id(p.getId())
            .organizationId(p.getOrganizationId())
            .organizationName(p.getOrganizationName())
//            .vouchers(p.getVouchers())
            .vouchersIssued(p.getVouchersIssued())
            .vouchersRedeemed(p.getVouchersRedeemed())
            .withdrawn(p.getWithdrawn())
            .build();
}
