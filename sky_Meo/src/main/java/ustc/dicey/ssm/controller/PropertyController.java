package ustc.dicey.ssm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ustc.dicey.ssm.pojo.Category;
import ustc.dicey.ssm.pojo.Property;
import ustc.dicey.ssm.service.CategoryService;
import ustc.dicey.ssm.service.PropertyService;
import ustc.dicey.ssm.util.Page;

import java.util.List;

// 属性管理

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;

    @RequestMapping("admin_property_add")
    public String add(Model model, Property p) {
//        1. 在listProperty.jsp页面提交数据的时候，除了提交属性名称，还会提交cid
//        2. 在PropertyController通过参数Property 接受注入
//        3. 通过propertyService保存到数据库
//        4. 客户端跳转到admin_property_list,并带上参数cid
        propertyService.add(p);
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String delete(int id) {
        // 在PropertyController的delete方法中获取id
        Property p = propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    // 这个编辑是编辑属性页面的属性
    @RequestMapping("admin_property_edit")
    public String edit(Model model, int id) {
        // 根据目录的id查询

        // 在PropertyController的edit方法中，根据id获取Property对象
        Property p = propertyService.get(id);

        // 根据properoty对象的cid属性获取Category对象，并把其设置在Property对象的category属性上
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);

        // 把Property对象放在request的 "p" 属性中
        model.addAttribute("p", p);

        // 服务端跳转到admin/editProperty.jsp
        return "admin/editProperty";

        // 在editProperty.jsp中显示属性名称,在editProperty.jsp中隐式提供id和cid( cid 通过 p.category.id 获取)
    }

    @RequestMapping("admin_property_update")
    public String update(Property p) {
        // 在PropertyController的**update**方法中获取Property对象
        // 借助propertyService更新这个对象到数据库
        propertyService.update(p);

        // 客户端跳转到admin_property_list，并带上参数cid
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    // 查询方法, 获取分类 cid,和分页对象page,只在重定向中用到了,cid来自拦截
    @RequestMapping("admin_property_list")
    public String list(int cid, Model model,  Page page) {
        Category c = categoryService.get(cid);

        // System.out.println("***");
        // 通过PageHelper设置分页参数
        PageHelper.offsetPage(page.getStart(),page.getCount());

        // 基于cid，获取当前分类下的属性集合
        List<Property> ps = propertyService.list(cid);

        // 通过PageInfo获取属性总数
        int total = (int) new PageInfo<>(ps).getTotal();

        // 把总数设置给分页page对象
        page.setTotal(total);

        // 拼接字符串"&cid="+c.getId()，设置给page对象的Param值。 因为属性分页都是基于当前分类下的分页，所以分页的时候需要传递这个cid
        // 把&cid= 参数设置到在page对象的param属性上
        page.setParam("&cid="+c.getId());

        // 把属性集合设置到 request的 "ps" 属性上
        model.addAttribute("ps", ps);

        // 把分类对象设置到 request的 "c" 属性上。 ( 这个c有什么用呢？ 在后面步骤的 其他-面包屑导航 中会用于显示分类名称)
        model.addAttribute("c", c);

        // 把分页对象设置到 request的 "page" 对象上
        model.addAttribute("page", page);
        // System.out.println("***");

        return "admin/listProperty";
    }

}
