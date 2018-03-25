package ustc.dicey.ssm.mapper;

import java.util.List;
import ustc.dicey.ssm.pojo.OrderItem;
import ustc.dicey.ssm.pojo.OrderItemExample;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}