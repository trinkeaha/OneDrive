package com.trinke.onedrive.api;

import com.trinke.onedrive.common.vo.R;
import com.trinke.onedrive.service.CarIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value ="操作车辆索引" ,tags = "操作车辆索引")
public class CarSearchController {
    @Autowired
    private CarIndexService carIndexService;

    //全部查询  分页
    @GetMapping("/api/search/carall.do")
    @ApiOperation(value = "实现整个内容查询",notes = "实现整个内容查询 分页")
    public R queryAll(int page, int size){
        return carIndexService.queryAll(page, size);
    }

    //模糊查询  分页
    @GetMapping("/api/search/carlike.do")
    @ApiOperation(value = "实现id的模糊查询",notes = "实现id的模糊查询 分页")
    public R queryLike(int page,int size,String msg){
        return carIndexService.queryLike(page, size, msg);
    }

}