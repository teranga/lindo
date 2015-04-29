package com.jalarbee.lindo.dao;

import com.jalarbee.lindo.CassandraRepository;
import com.jalarbee.lindo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Repository;

/**
 * @author Abdoulaye Diallo
 */

@Repository(value = "productDao")
public class ProductDaoImpl extends CassandraRepository<Product, MapId> implements ProductDao {

    @Autowired private CassandraOperations cassandraOps;

    @Override
    protected CassandraOperations cassandraOps() {
        return cassandraOps;
    }

}
