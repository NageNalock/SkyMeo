package ustc.dicey.ssm.mapper;

import ustc.dicey.ssm.pojo.Category;
import ustc.dicey.ssm.util.Page;

import java.util.List;

public interface CategoryMapper {

    public List<Category> list(Page page);

    public int total();  // 获取总数方法
}
