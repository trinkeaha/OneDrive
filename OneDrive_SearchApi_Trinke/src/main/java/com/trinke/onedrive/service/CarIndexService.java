package com.trinke.onedrive.service;

import com.trinke.onedrive.common.vo.R;
import com.trinke.onedrive.model.CarIndex;

import java.util.List;

public interface CarIndexService {
    R<List<CarIndex>> queryAll(int page, int size);
    R<List<CarIndex>> queryLike(int page,int size,String msg);
}
