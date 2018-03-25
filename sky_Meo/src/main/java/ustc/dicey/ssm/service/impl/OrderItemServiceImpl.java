package ustc.dicey.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ustc.dicey.ssm.mapper.OrderItemMapper;
import ustc.dicey.ssm.pojo.Order;
import ustc.dicey.ssm.pojo.OrderItem;
import ustc.dicey.ssm.pojo.OrderItemExample;
import ustc.dicey.ssm.pojo.Product;
import ustc.dicey.ssm.service.OrderItemService;
import ustc.dicey.ssm.service.ProductService;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;

    @Override
    public void add(OrderItem c) {
        orderItemMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(OrderItem c) {
        orderItemMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public OrderItem get(int id) {
        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
        setProduct(result);
        return result;
    }

    public List<OrderItem> list(){
        OrderItemExample example =new OrderItemExample();
        example.setOrderByClause("id desc");
        return orderItemMapper.selectByExample(example);

    }

    @Override
    public void fill(List<Order> os) {
        for (Order o : os) {
            fill(o);
        }
    }

    public void fill(Order o) {
        // 在订单管理界面，首先是遍历多个订单，然后遍历这个订单下的多个订单项
        // 即一对多的关系

        // 根据订单id查询出其对应的所有订单项
        OrderItemExample example =new OrderItemExample();
        example.createCriteria().andOidEqualTo(o.getId());
        example.setOrderByClause("id desc");
        List<OrderItem> ois =orderItemMapper.selectByExample(example);

        // 通过setProduct为所有的订单项设置Product属性
        setProduct(ois);

        // 遍历所有的订单项，然后计算出该订单的总金额和总数量
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi : ois) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();
        }

        // 最后再把订单项设置在订单的orderItems属性上。
        o.setTotal(total);
        o.setTotalNumber(totalNumber);
        o.setOrderItems(ois);

    }

    public void setProduct(List<OrderItem> ois){
        for (OrderItem oi: ois) {
            setProduct(oi);
        }
    }

    private void setProduct(OrderItem oi) {
        Product p = productService.get(oi.getPid());
        oi.setProduct(p);
    }
}
