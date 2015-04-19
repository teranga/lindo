package com.jalarbee.lindo;

import com.datastax.driver.core.utils.UUIDs;
import com.jalarbee.lindo.domain.Product;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Abdoulaye Diallo
 */

public class BaseProductTest extends BaseUnitTest {


    protected Product createDieselProduct() {
        return Product.builder().name("Diesel")
                .category("Fuel")
                .organizationId(UUIDs.timeBased())
                .purchasePrice(new BigDecimal("645.98"))
                .retailPrice(new BigDecimal("723.45"))
                .id(UUIDs.timeBased())
                .registrationDate(new Date())
                .build();
    }
}
