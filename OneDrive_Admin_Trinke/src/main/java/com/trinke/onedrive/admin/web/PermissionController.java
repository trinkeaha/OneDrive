package com.trinke.onedrive.admin.web;

import com.trinke.onedrive.admin.core.vo.R;
import com.trinke.onedrive.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    //校验指定的权限是否存在
    @GetMapping("/web/permission/checkperms.do")
    public R checkPer(String prms){
        return permissionService.checkPerms(prms);
    }

}
