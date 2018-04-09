package org.erp.myproductionsrc.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping(value = "/ajaxLogin")
    public @ResponseBody Map<String,Object> ajaxLogin(@RequestParam String username, @RequestParam String password){
        Map<String,Object> map = new HashMap<String,Object>();
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {

            UsernamePasswordToken token = new UsernamePasswordToken(username,password);

            try{
                currentUser.login(token);
            }catch(UnknownAccountException ex) {
                map.put("msg", "account_error");
            }catch(ExcessiveAttemptsException ex) {
                map.put("msg", "login_fail_recount_error");
            }
            System.out.print("no print");
        }
       // map.put("msg", "account_error");
       // System.out.print("no print");
        return map;
    }
}
