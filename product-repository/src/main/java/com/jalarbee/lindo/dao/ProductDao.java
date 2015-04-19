package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */

public interface ProductDao extends CrudRepository<Product, UUID> {

}
