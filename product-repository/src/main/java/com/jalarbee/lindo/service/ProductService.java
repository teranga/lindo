package com.jalarbee.lindo.service;

import com.jalarbee.lindo.domain.Category;
import com.jalarbee.lindo.domain.Product;
import org.springframework.data.domain.Pageable;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author Abdoulaye Diallo
 */
public interface ProductService {

    Stream<Product> getCatalog(UUID organizationId, Pageable pageable);

    Product create(Product product);

}
