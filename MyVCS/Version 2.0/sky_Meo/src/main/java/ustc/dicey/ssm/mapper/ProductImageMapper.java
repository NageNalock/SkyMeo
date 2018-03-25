package ustc.dicey.ssm.mapper;

import java.util.List;
import ustc.dicey.ssm.pojo.ProductImage;
import ustc.dicey.ssm.pojo.ProductImageExample;

public interface ProductImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    List<ProductImage> selectByExample(ProductImageExample example);

    ProductImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}