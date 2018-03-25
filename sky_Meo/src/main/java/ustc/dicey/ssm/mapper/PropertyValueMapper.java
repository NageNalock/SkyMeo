package ustc.dicey.ssm.mapper;

import java.util.List;
import ustc.dicey.ssm.pojo.PropertyValue;
import ustc.dicey.ssm.pojo.PropertyValueExample;

public interface PropertyValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PropertyValue record);

    int insertSelective(PropertyValue record);

    List<PropertyValue> selectByExample(PropertyValueExample example);

    PropertyValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PropertyValue record);

    int updateByPrimaryKey(PropertyValue record);
}