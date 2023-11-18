package com.carlos.ejemplomarket.persistence;

import com.carlos.ejemplomarket.domain.Product;
import com.carlos.ejemplomarket.domain.repository.ProductRepository;
import com.carlos.ejemplomarket.persistence.crud.ProductoCrudRepository;
import com.carlos.ejemplomarket.persistence.entity.Producto;
import com.carlos.ejemplomarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }


    public Optional<List<Producto>> getEscasos (int cantidad, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, estado=true);

    }

    public Optional<Producto> getProducto (int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
