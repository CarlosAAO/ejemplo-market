package com.carlos.ejemplomarket.domain.repository;

import com.carlos.ejemplomarket.domain.Product;
import com.carlos.ejemplomarket.persistence.ProductoRepository;
import com.carlos.ejemplomarket.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
