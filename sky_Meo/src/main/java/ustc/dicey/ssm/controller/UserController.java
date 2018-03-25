package ustc.dicey.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ustc.dicey.ssm.pojo.User;
import ustc.dicey.ssm.service.UserService;
import ustc.dicey.ssm.util.Page;

import java.util.List;

/**
 * 增加交由前台用户注册功能
 * 删除不提供（用户信息是最重要的资料）
 * 修改不提供，应该由前台用户自己完成
 * */


@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("admin_user_list")
    public String list(Model model, Page page){  // 获取分页对象
        // 设置分页信息
        PageHelper.offsetPage(page.getStart(),page.getCount());

        // 查询用户集合
        List<User> us= userService.list();

        // 通过PageInfo获取总数，并设置在page对象上
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);

        model.addAttribute("us", us);
        model.addAttribute("page", page);

        return "admin/listUser";
    }
}
