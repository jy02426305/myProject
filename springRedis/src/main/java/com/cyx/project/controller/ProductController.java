package com.cyx.project.controller;

import com.cyx.project.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.Date;

@Controller
@RequestMapping(value="product")
public class ProductController {
    @RequestMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView view=new ModelAndView();
        view.setViewName("product/list.jsp");
        view.addObject("name","CPU");
        Product product=new Product();
        product.setCreateTime(new Date());
        product.setId(1);
        view.addObject("product",product);
        return view;
    }

    @RequestMapping(value = "/getNames")
    @ResponseBody
    public String[] getNames(){
        return new String[]{"张三","李四","王五"};
    }

    @RequestMapping(value = "/restfulStyle/{name}")
    public ModelAndView restfulStyle(@PathVariable(value = "name") String username){
        System.out.println(username);
        return null;
    }

    @RequestMapping(value = "/paramNameDiffer")
    public ModelAndView paramNameDiffer(@RequestParam(value = "username") String name){
        System.out.println(name);
        return null;
    }

    /**
     * 传参
     * @param model
     * @return
     */
    @RequestMapping(value="/data1")
    public String data1(Model model){
        model.addAttribute("username","张三");
        return "product/data1.jsp";
    }

    /**
     * 能访问WEB-INF内容
     * @param model
     * @return
     */
    @RequestMapping(value="jump1")
    public String jump1(Model model){
        model.addAttribute("msg","越跳越健康");
        return "forward:/WEB-INF/views/product/jump1.jsp";
    }

    /**
     * 不能访问WEB-INF内容
     * @param model
     * @return
     */
    @RequestMapping(value="jump2")
    public String jump2(Model model){
        model.addAttribute("msg","越跳越健康");
        return "redirect:/WEB-INF/views/product/jump2.jsp";
    }
}
