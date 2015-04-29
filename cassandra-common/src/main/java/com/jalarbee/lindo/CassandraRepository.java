package com.jalarbee.lindo;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Abdoulaye Diallo
 */
public abstract class CassandraRepository<T, K extends Serializable> implements CrudRepository<T, K> {


    @SuppressWarnings("unchecked")
    public CassandraRepository() {
        ParameterizedType genericType = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericType.getActualTypeArguments()[0];
        this.keyClass = (Class<K>) genericType.getActualTypeArguments()[1];
    }

    protected abstract CassandraOperations cassandraOps();

    private final Class<T> entityClass;
    private final Class<K> keyClass;

    @Override
    public <S extends T> S save(S entity) {
        return cassandraOps().insert(entity);
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        return cassandraOps().insert(entities);
    }

    @Override
    public T findOne(K id) {
        return cassandraOps().selectOneById(entityClass, id);
    }

    @Override
    public boolean exists(K id) {
        return cassandraOps().exists(entityClass, id);
    }

    @Override
    public Iterable<T> findAll() {
        throw new java.lang.UnsupportedOperationException("findAll is a not allowed.");
    }

    @Override
    public Iterable<T> findAll(Iterable<K> ids) {
        return cassandraOps().selectBySimpleIds(entityClass, ids);
    }

    @Override
    public long count() {
        return cassandraOps().count(entityClass);
    }

    @Override
    public void delete(K k) {
        cassandraOps().deleteById(entityClass, k);
    }

    @Override
    public void delete(T entity) {
        cassandraOps().delete(entity);
    }

    @Override
    public void delete(Iterable<? extends T> entities) {
        cassandraOps().delete(entities);
    }

    @Override
    public void deleteAll() {
        cassandraOps().deleteAll(entityClass);
    }
}
