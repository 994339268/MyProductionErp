package org.erp.myproductionsrc.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.erp.myproductionsrc.Util.MD5Util;
import org.erp.myproductionsrc.domain.authority.SysUser;
import org.erp.myproductionsrc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    //授权认证
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String)principalCollection.getPrimaryPrincipal();
        System.out.println(username);
        System.out.println("doGetAuthorizationInfo");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<String> permissions = new ArrayList<String>();
        String permission = "order:view";
        permissions.add(permission);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    //用户认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // token是用户输入的用户名和密码
        // 第一步从token中取出用户名

        UsernamePasswordToken uptoken = (UsernamePasswordToken)token;

        String username = uptoken.getUsername();
        String password = String.valueOf(uptoken.getPassword());
        SysUser sysUser = sysUserService.findUserByName(username);
        String cresalt = username + password + sysUser.getSalt();
        System.out.print(sysUser.getSalt());


        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                username, sysUser.getPassword(), ByteSource.Util.bytes(cresalt), this.getName());

        return simpleAuthenticationInfo;
        //return null;
    }
}
