package com.geekbrains.product.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
public class ProductShowController {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String showProducts(Model model) {
        ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8190/", HttpMethod.GET, null, List.class);
        List<ProductDTO> productDTO = (List<ProductDTO>) responseEntity.getBody();
        model.addAttribute("products", productDTO);
        return "catalog";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8190/delete/" + id, HttpMethod.DELETE, null, String.class);
        return "redirect:/";
    }

    @GetMapping("/product/new")
    public String showFormProduct() {
        return "new_product";
    }
    @PostMapping("/add")
    public String addProduct(Model model, @RequestParam String title
            , @RequestParam String description
            , @RequestParam String cost) {
        String url = "http://localhost:8190/?title=" + title
                + "&description=" + description
                + "&cost=" + cost;
        System.out.println(url);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, null, String.class);

        return "redirect:/";
    }
}
