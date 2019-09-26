package com.trinke.onedrive.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trinke.onedrive.admin.core.config.SystemConfig;
import com.trinke.onedrive.admin.core.util.EncryptionUtil;
import com.trinke.onedrive.admin.core.util.RUtil;
import com.trinke.onedrive.admin.core.vo.R;
import com.trinke.onedrive.admin.dao.MemberDao;
import com.trinke.onedrive.admin.dto.MenuDto;
import com.trinke.onedrive.admin.dto.MenuItem;
import com.trinke.onedrive.admin.dto.UserDto;
import com.trinke.onedrive.admin.entity.Member;
import com.trinke.onedrive.admin.entity.Sys_permission;
import com.trinke.onedrive.admin.service.MemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {
    @Override
    public R login(UserDto userDto) {
        //1、查询账号对应的用户信息
        Member member=getBaseMapper().selectOne(new QueryWrapper<Member>().eq("mname",userDto.getUname()));
        //2、验证账号是否正确
        if(member!=null){
            //3、验证密码是否正确  密文比对
            if(member.getPassword().equals(EncryptionUtil.AESEnc(SystemConfig.PASSKEY,userDto.getPsw()))){
                //登录成功
                //4、创建Shiro的令牌
                UsernamePasswordToken token=new UsernamePasswordToken(member.getMname(),member.getPassword());
                //5、调用Shiro登录 告诉Shiro登录成功
                Subject subject= SecurityUtils.getSubject();
                subject.login(token); //调用Realm的认证方法
                //6、将登录用户信息存储到Session中
                subject.getSession().setAttribute("member",member);
                return RUtil.setOK("登录成功");
            }
        }
        return RUtil.setERROR("账号或密码不正确");
    }

    @Override
    public R loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return RUtil.setOK("OK");
    }

    @Override
    public R<List<MenuDto>> queryMenus() {
        Member member = (Member) SecurityUtils.getSubject().getSession().getAttribute("member");
        List<Sys_permission> list = getBaseMapper().selectMenus(member.getId());

        List<MenuDto> menus = new ArrayList<>();
        for (Sys_permission p : list) {
            if (p.getLevel() == 1) {
                MenuDto menuDto = new MenuDto();
                menuDto.setIcon(p.getIcon());
                menuDto.setId(p.getId());
                menuDto.setName(p.getName());
                menuDto.setChilds(new ArrayList<>());
                menus.add(menuDto);
            } else {
                int index = searchParent(menus,p);
                if (index > -1){
                    MenuItem item = new MenuItem();
                    item.setId(p.getId());
                    item.setIcon(p.getIcon());
                    item.setName(p.getName());
                    item.setMurl(p.getPrms());
                    item.setLevel(p.getLevel());
                    menus.get(index).getChilds().add(item);
                }
            }
        }
        return RUtil.setOK("OK",menus);
    }


    private int searchParent(List<MenuDto> list, Sys_permission p) {
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getId() == p.getParentid()) {
                return i;
            }
        }
        return -1;
    }

}
