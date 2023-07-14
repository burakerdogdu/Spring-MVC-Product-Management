package com.works.product_management.props;

import lombok.Data;

@Data
public class Products {
    private Integer pid;
    private String title;
    private Integer price;
    private String detail;
    private Integer stock;
}
