package com.github.awsservices.inventory.application.core.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {

    private Long id;

    private String sku;

    private String description;

    private BigDecimal price;

}
