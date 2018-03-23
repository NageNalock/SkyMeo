package ustc.dicey.ssm.controller;

/*
* @Controller声明当前类是一个控制器
* @RequestMapping("")表示访问的时候无需额外的地址
* @Autowired把CategoryServiceImpl自动装配进了CategoryService 接口
* @RequestMapping("admin_category_list") 映射admin_category_list路径的访问
*
* **/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ustc.dicey.ssm.pojo.Category;
import ustc.dicey.ssm.service.CategoryService;
import ustc.dicey.ssm.util.Page;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model, Page page)
    {
        // 获取所有Category对象,并放入cs中
        List<Category> cs = categoryService.list(page);

        int total = categoryService.total();
        page.setTotal(total);

        // 存入Model,Model类是用来给前端JSP传递数据来生成html的
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);

        // “admin/listCategory” 会根据后续的springMVC.xml 配置文件，跳转到 WEB-INF/jsp/admin/listCategory.jsp 文件
        return "admin/listCategory";
    }
}
