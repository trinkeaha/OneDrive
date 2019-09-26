package com.trinke.onedrive.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trinke.onedrive.admin.core.vo.R;
import com.trinke.onedrive.admin.dto.MenuDto;
import com.trinke.onedrive.admin.dto.UserDto;
import com.trinke.onedrive.admin.entity.Member;

import java.util.List;

public interface MemberService extends IService<Member> {
    R login(UserDto userDto);

    R loginOut();

    R<List<MenuDto>> queryMenus();
}
