package com.github.awsservices.inventory.application.core.domain;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private String orderId;

    private String customerEmail;

    private double amount;

    private List<Item> items;

}
