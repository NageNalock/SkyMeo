package ustc.dicey.ssm.mapper;

import java.util.List;
import ustc.dicey.ssm.pojo.Property;
import ustc.dicey.ssm.pojo.PropertyExample;

public interface PropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}