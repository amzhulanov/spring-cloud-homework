package com.geekbrains.product.show;

import java.math.BigDecimal;

public interface ProductDTO {
    Long getId();
    String getDescription();
    String getTitle();
    BigDecimal getCost();

}
