package com.trinke.onedrive.admin.shiro;

import com.trinke.onedrive.admin.dao.MemberDao;
import com.trinke.onedrive.admin.entity.Member;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShiroRealm extends AuthorizingRealm {

    @Autowired(required = false)
    private MemberDao memberDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        Member member = (Member) SecurityUtils.getSubject().getSession().getAttribute("member");
        Set<String> perms = memberDao.selectPerms(member.getId());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(perms);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (token != null) {
            return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
        } else {
            return null;
        }
    }
}
