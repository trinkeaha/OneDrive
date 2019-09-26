package com.trinke.onedrive.admin.out.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trinke.onedrive.admin.entity.car.CarBrand;
import com.trinke.onedrive.admin.out.dao.CarBrandDao;
import com.trinke.onedrive.admin.out.service.CarBrandService;
import org.springframework.stereotype.Service;

@Service
public class CarBrandServiceImpl extends ServiceImpl<CarBrandDao, CarBrand> implements CarBrandService {
}
