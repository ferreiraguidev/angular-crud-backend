package com.example.angular.controller.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPutReqBody {
    public Long id;
    public String name;
    public String category;
}
