package com.trinke.onedrive.dao;

import com.trinke.onedrive.model.CarIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CarIndexDao extends ElasticsearchRepository<CarIndex,Integer> {
}
