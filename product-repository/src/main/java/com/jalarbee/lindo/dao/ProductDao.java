package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.domain.Product;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Abdoulaye Diallo
 */

public interface ProductDao extends CrudRepository<Product, MapId> {

}
