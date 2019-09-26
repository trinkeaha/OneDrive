package com.trinke.onedrive.service.impl;

import com.trinke.onedrive.common.util.RUtil;
import com.trinke.onedrive.common.vo.R;
import com.trinke.onedrive.dao.NewsIndexDao;
import com.trinke.onedrive.service.NewsIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NewsIndexServiceImpl implements NewsIndexService {
    @Autowired
    private NewsIndexDao newsIndexDao;
    @Override
    public R queryAll(int page, int size) {

        return RUtil.setOK("OK",newsIndexDao.findAll(PageRequest.of(page, size)));
    }
}
