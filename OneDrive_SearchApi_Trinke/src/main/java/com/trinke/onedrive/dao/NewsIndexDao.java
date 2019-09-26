package com.trinke.onedrive.dao;

import com.trinke.onedrive.model.NewsIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NewsIndexDao extends ElasticsearchRepository<NewsIndex, String> {
}
