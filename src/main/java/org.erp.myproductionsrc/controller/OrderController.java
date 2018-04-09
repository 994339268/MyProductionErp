package org.erp.myproductionsrc.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequiresPermissions("order:view")
    @RequestMapping("/find")
    public String find() throws Exception{
        return "order_list";
    }
  /* // @RequiresPermissions("order:view")
    @RequestMapping("/find")
    public ModelAndView find() throws Exception{
        ModelAndView mv = new ModelAndView();

        // mv.setViewName("unauthorized");
        mv.setViewName("unauthorized");
        return mv;

    }*/

}
