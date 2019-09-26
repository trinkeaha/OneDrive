package com.trinke.onedrive.service.impl;

import com.trinke.onedrive.common.util.RUtil;
import com.trinke.onedrive.common.vo.R;
import com.trinke.onedrive.dao.CarIndexDao;
import com.trinke.onedrive.model.CarIndex;
import com.trinke.onedrive.service.CarIndexService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarIndexServiceImpl implements CarIndexService {

    @Autowired
    private CarIndexDao carIndexDao;
    @Override
    public R<List<CarIndex>> queryAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return RUtil.setOK("OK",carIndexDao.findAll(pageable).iterator());
    }

    @Override
    public R<List<CarIndex>> queryLike(int page, int size, String msg) {
        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("id","%"+msg+"%");
        return RUtil.setOK("OK",carIndexDao.search(wildcardQueryBuilder, PageRequest.of(page,size,Sort.by("id").ascending())));
    }
}
