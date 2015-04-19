package com.jalarbee.lindo.service;

import com.jalarbee.lindo.BaseProductTest;
import com.jalarbee.lindo.BaseUnitTest;
import com.jalarbee.lindo.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Abdoulaye Diallo
 */
public class ProductServiceTest extends BaseProductTest {

    @Autowired
    private ProductService productService;


    @Test
    public void getCatalog() {
        Product p = productService.create(createDieselProduct());
        assertThat(p).isNotNull();
        assertThat(p.getName()).isEqualTo("Diesel");
        assertThat(p.getCategory()).isEqualTo("Fuel");

    }
}
