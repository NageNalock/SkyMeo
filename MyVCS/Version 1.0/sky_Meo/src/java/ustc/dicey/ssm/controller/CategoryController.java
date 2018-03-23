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
import ustc.dicey.ssm.util.ImageUtil;
import ustc.dicey.ssm.util.Page;
import ustc.dicey.ssm.util.UploadedImageFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    // 增加add方法,参数 Category c接受页面提交的分类名称,参数 session 用于在后续获取当前应用的路径,UploadedImageFile 用于接受上传的图片
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException
    {
        //  通过categoryService保存c对象
        categoryService.add(c);

        // 通过session获取ControllerContext,再通过getRealPath定位存放分类图片的路径。
        // session拿到了FTP上传的文件地址,然后讲地址存到数据库中
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));

        // 根据分类id创建文件名
        File file = new File(imageFolder, c.getId() + ".jpg");
        if (!file.getParentFile().exists())
        {
            // 如果/img/category不存在则创建该目录,否则后续保存浏览器传过来的的图片,会提示无法保存
            file.getParentFile().mkdirs();
        }

        // 把浏览器传递来的图片保存在指定位置
        uploadedImageFile.getImage().transferTo(file);

        // 确保图片格式为jpg
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);

        return "redirect:/admin_category_list";


    }
}
