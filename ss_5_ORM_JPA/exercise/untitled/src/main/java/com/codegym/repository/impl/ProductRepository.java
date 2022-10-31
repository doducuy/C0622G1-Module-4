package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select s from Product as s ",Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);

    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(Product product) {

    }
}
