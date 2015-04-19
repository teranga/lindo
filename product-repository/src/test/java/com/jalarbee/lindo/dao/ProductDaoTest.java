package com.jalarbee.lindo.dao;

import com.datastax.driver.core.utils.UUIDs;
import com.jalarbee.lindo.BaseProductTest;
import com.jalarbee.lindo.BaseUnitTest;
import com.jalarbee.lindo.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Abdoulaye Diallo
 */
@Slf4j
public class ProductDaoTest extends BaseProductTest {

    @Autowired private ProductDao productDao;

    @Test
    public void saveProduct() {
        Product p = createDieselProduct();
        productDao.save(p);
    }

}
