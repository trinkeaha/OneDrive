package com.trinke.onedrive.admin.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trinke.onedrive.admin.core.util.RUtil;
import com.trinke.onedrive.admin.core.vo.R;
import com.trinke.onedrive.admin.entity.car.CarBrand;
import com.trinke.onedrive.admin.out.service.CarBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Api(value = "车品牌",tags = "车品牌")
@RestController
public class CarBrandController {

    @Autowired
    private CarBrandService brandService;

    //新增
    @PostMapping("/web/carbrand/save.do")
    @ApiOperation(value = "新增车辆内容",notes = "新增车辆内容")
    public R save(CarBrand carBrand){
        return RUtil.setR(brandService.save(carBrand),"新增品牌");
    }
    //删除
    @DeleteMapping("/web/carbrand/del.do")
    @ApiOperation(value = "删除车辆内容",notes = "删除车辆内容")
    public R del(int id){
        return RUtil.setR(brandService.removeById(id),"删除品牌");
    }
    //批量删除
    @DeleteMapping("/web/carbrand/delbatchids.do")
    @ApiOperation(value = "批量删除车辆内容",notes = "批量删除车辆内容")
    public R delBatch(int[] ids){
        return RUtil.setR(brandService.removeByIds(Arrays.asList(ids)),"批量删除品牌");
    }


    @GetMapping("/web/carbrand/querypage.do")
    @ApiOperation(value = "分页查询",notes = "分页查询车辆信息")
    public R query(Map<String, Object> map) {
        Page<CarBrand> page = new Page<CarBrand>((long)map.get("page"),(long)map.get("size"));

        QueryWrapper<CarBrand> queryWrapper = new QueryWrapper<>();

        if (map.containsKey("name") && map.containsKey("country")) {
            queryWrapper.lambda().like(CarBrand::getName,"%"+map.get("name")+"%").eq(CarBrand::getCountry,map.get("country"));

        } else {
            if (map.containsKey("name")) {
                queryWrapper.like("name","%"  + map.get("name") + "%");

            }
            if (map.containsKey("country")) {
                String c = map.get("country").toString();
                if (c.equals("国产系列")) {
                    queryWrapper.eq("country", c);
                }else {
                    queryWrapper.ne("country", c);
                }
            }
        }
        return RUtil.setOK("OK",brandService.page(page,queryWrapper));
    }

    //详情信息
    @GetMapping("/web/carbrand/querydetail.do")
    @ApiOperation(value = "根据id查询车辆信息", notes = "根据id查询车辆信息")
    public R query(int id){
        return RUtil.setOK("OK",brandService.getById(id));
    }

}
