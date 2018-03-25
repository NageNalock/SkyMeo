package ustc.dicey.ssm.mapper;

import java.util.List;
import ustc.dicey.ssm.pojo.Review;
import ustc.dicey.ssm.pojo.ReviewExample;

public interface ReviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Review record);

    int insertSelective(Review record);

    List<Review> selectByExample(ReviewExample example);

    Review selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);
}