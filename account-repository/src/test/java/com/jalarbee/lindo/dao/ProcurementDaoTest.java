package com.jalarbee.lindo.dao;

import com.datastax.driver.core.utils.UUIDs;
import com.jalarbee.lindo.BaseAccountTest;
import com.jalarbee.lindo.domain.Organization;
import com.jalarbee.lindo.domain.procure.Procurement;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Abdoulaye Diallo
 */
public class ProcurementDaoTest extends BaseAccountTest {

    @Autowired private ProcurementDao procurementDao;


    @Test
    public void createProcurement() throws InterruptedException {

        procurementDao.save(buildOne());
        Thread.sleep(1000);
        procurementDao.save(buildOne());
        Thread.sleep(1000);
        procurementDao.save(buildOne());
        Thread.sleep(1000);
        procurementDao.save(buildOne());
        Thread.sleep(1000);
        procurementDao.save(buildOne());
        Thread.sleep(1000);
        procurementDao.save(buildOne());
        Thread.sleep(1000);
        procurementDao.save(buildOne());
    }

    private Procurement buildOne() {
        Organization organization = createOrgJavaLove();
        return Procurement.builder()
                .dateFrom(new Date())
                .organizationId(organization.getId())
                .id(UUIDs.timeBased())
                .withdrawn(new BigDecimal(10000.00))
                .vouchersRedeemed(15)
                .vouchers(new HashMap<BigDecimal, Integer>() {
                    {
                        put(new BigDecimal("125000.00"), 17);
                        put(new BigDecimal("230000.00"), 15);
                        put(new BigDecimal("600000.00"), 25);
                    }
                })
                .amount(new BigDecimal(355000.00))
                .organizationName(organization.getName())
                .status("IN_PROGRESS")
                .build();
    }
}
