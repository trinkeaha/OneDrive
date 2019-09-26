package com.trinke.onedrive.admin.web;

import com.trinke.onedrive.admin.core.vo.R;
import com.trinke.onedrive.admin.dto.UserDto;
import com.trinke.onedrive.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/web/member/login.do")
    public R login(UserDto userDto) {
        return memberService.login(userDto);
    }
}
