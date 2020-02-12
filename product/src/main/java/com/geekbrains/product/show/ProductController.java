package com.geekbrains.product.show;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public List<ProductDTO> getProducts() {
        return productRepository.findAllBy();
    }

    @PostMapping("/")
    public String saveProduct(@RequestParam String title, @RequestParam String description, @RequestParam BigDecimal cost){
        Product product=new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setCost(cost);
        productRepository.save(product);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return "true";
    }

    @PostMapping("/add")
    public String addProduct(Model model){

        return  "";
    }


}
