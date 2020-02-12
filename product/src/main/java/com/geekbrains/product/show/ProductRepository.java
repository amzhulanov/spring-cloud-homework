package com.geekbrains.product.show;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<ProductDTO> findAllBy();
    Product save(Product product);
    //ProductDTO save(ProductDTO productDTO);
    void deleteById(Long id);
}


