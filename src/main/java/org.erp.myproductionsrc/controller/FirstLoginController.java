package org.erp.myproductionsrc.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FirstLoginController {



    @RequestMapping(value={"/","/first","/login"})
    public String firstlogin(){
        return "login";
    }


    //首页
    @RequestMapping("/home")
    public String loginhome(){

        //Subject subject = SecurityUtils.getSubject();
        //取身份信息
        //ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
       // List<SysPermission> permissionList = null;
       // permissionList  = mysysService.findPermissionListByUserId(activeUser.getUserid());
        return "home";
    }
}
