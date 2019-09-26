package com.trinke.onedrive.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "trinke",type = "car")
@Data
public class CarIndex {
    private int id;
    private String name;
    private String brand;
    private String ctype;
}
