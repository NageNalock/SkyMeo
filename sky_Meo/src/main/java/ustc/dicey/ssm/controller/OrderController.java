package ustc.dicey.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ustc.dicey.ssm.pojo.Order;
import ustc.dicey.ssm.service.OrderItemService;
import ustc.dicey.ssm.service.OrderService;
import ustc.dicey.ssm.util.Page;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 订单的增加和删除，都是在前台进行的
 * 只提供list方法和delivery(发货)方法
 *
 * */
@Controller
@RequestMapping("")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("admin_order_list")
    public String list(Model model, Page page){
        // 获取分页对象
        PageHelper.offsetPage(page.getStart(),page.getCount());

        // 查询订单集合
        List<Order> os= orderService.list();

        // 获取订单总数并设置在分页上
        int total = (int) new PageInfo<>(os).getTotal();
        page.setTotal(total);

        orderItemService.fill(os);

        model.addAttribute("os", os);
        model.addAttribute("page", page);

        return "admin/listOrder";
    }

    @RequestMapping("admin_order_delivery")
    public String delivery(Order o) throws IOException {
        // 注入订单对象
        o.setDeliveryDate(new Date());

        // 修改发货时间，设置发货状态
        o.setStatus(OrderService.waitConfirm);

        // 更新到数据库
        orderService.update(o);
        return "redirect:admin_order_list";
    }
}
