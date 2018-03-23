package com.ustc.ssm.controller;

import com.ustc.ssm.pojo.Category;
import com.ustc.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
* 注解@Controller声明当前类是一个控制器
* 注解@RequestMapping("")表示访问的时候无需额外的地址
* 注解@Autowired把CategoryServiceImpl自动装配进了CategoryService 接口
* 注解@RequestMapping("admin_category_list") 映射admin_category_list路径的访问
* 在list方法中，通过categoryService.list()获取所有的Category对象，然后放在"cs"中，并服务端跳转到 “admin/listCategory” 视图。
*
* “admin/listCategory” 会根据后续的springMVC.xml 配置文件，跳转到 WEB-INF/jsp/admin/listCategory.jsp 文件
*
* **/
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model)
    {
        // 获取所有Category对象,并放入cs中
        List<Category> cs = categoryService.list();

        // 存入Model,Model类是用来给前端JSP传递数据来生成前端html页面数据
        model.addAttribute("cs", cs);

        // “admin/listCategory” 会根据后续的springMVC.xml 配置文件，跳转到 WEB-INF/jsp/admin/listCategory.jsp 文件
        return "admin/listCategory";
    }
}
