package ustc.dicey.ssm.mapper;

import java.util.List;
import ustc.dicey.ssm.pojo.User;
import ustc.dicey.ssm.pojo.UserExample;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}