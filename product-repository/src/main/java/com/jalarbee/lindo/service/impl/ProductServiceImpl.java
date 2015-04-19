package com.jalarbee.lindo.service.impl;

import com.jalarbee.lindo.dao.ProductDao;
import com.jalarbee.lindo.domain.Product;
import com.jalarbee.lindo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Abdoulaye Diallo
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired private ProductDao productDao;

    @Override
    public Stream<Product> getCatalog(UUID organizationId, Pageable pageable) {
        return StreamSupport.stream(productDao.findAll(Collections.singleton(organizationId)).spliterator(), false);

    }

    @Override
    public Product create(Product product) {
        return productDao.save(product);
    }


}
