package com.trinke.onedrive.server.controller;


import com.trinke.onedrive.common.util.RUtil;
import com.trinke.onedrive.common.vo.R;
import com.trinke.onedrive.entity.core.OneDir;
import com.trinke.onedrive.server.service.OneDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OneDirController {

    @Autowired
    private OneDirService dirService;

    @PostMapping("/server/dir/savedir.do")
    public R save(@RequestBody OneDir oneDir) {
        return RUtil.setR(dirService.save(oneDir),"新增字典");
    }

    @GetMapping("/server/dir/querydir.do")
    public R detail(@RequestParam("id") int id) {
        return RUtil.setOK("查询字典", dirService.getById(id));
    }

    @DeleteMapping("/server/dir/deldir.do")
    public R del(@RequestParam int id){
        return RUtil.setR(dirService.removeById(id), "删除字典");
    }

}
