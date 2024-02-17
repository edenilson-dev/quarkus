package com.elsistemas.repository;

import com.elsistemas.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}
