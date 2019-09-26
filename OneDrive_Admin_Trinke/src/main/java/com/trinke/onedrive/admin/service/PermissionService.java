package com.trinke.onedrive.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trinke.onedrive.admin.core.vo.R;
import com.trinke.onedrive.admin.entity.Sys_permission;

public interface PermissionService extends IService<Sys_permission> {

    R checkPerms(String perms);
}
