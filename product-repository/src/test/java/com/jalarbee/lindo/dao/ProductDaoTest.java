package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.BaseProductTest;
import com.jalarbee.lindo.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Abdoulaye Diallo
 */
@Slf4j
public class ProductDaoTest extends BaseProductTest {

    @Autowired private ProductDao productDao;

    @Test
    public void saveProduct() {
        Product p = createDieselProduct();
        p = productDao.save(p);
        assertThat(p).isNotNull();
        assertThat(p.getName()).isEqualTo("Diesel");
    }

}
