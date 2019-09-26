package com.trinke.onedrive.model;


import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "trinke",type = "news")
@Data
public class NewsIndex {
    private String id;
    private String title;
    private String time;
    private String url;

}
