package ustc.dicey.ssm.service;

import ustc.dicey.ssm.pojo.Order;
import ustc.dicey.ssm.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    void add(OrderItem c);

    void delete(int id);
    void update(OrderItem c);
    OrderItem get(int id);
    List list();

    void fill(List<Order> os);

    void fill(Order o);
}
