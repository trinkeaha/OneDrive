package com.trinke.onedrive.api.service;

import com.trinke.onedrive.common.vo.R;
import com.trinke.onedrive.entity.core.OneDir;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("CarProvider")
public interface OneDirService {

    //新增
    @PostMapping("/server/dir/savedir.do")
    R save(@RequestBody OneDir dir);
    //查询
    @GetMapping("/server/dir/querydir.do")
    R detail(@RequestParam("id") int id);
    //删除
    @DeleteMapping("/server/dir/deldir.do")
    R del(@RequestParam int id);

}
