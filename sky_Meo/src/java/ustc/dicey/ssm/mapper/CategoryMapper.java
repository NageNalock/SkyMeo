package ustc.dicey.ssm.mapper;

import ustc.dicey.ssm.pojo.Category;
import ustc.dicey.ssm.util.Page;

import java.util.List;

public interface CategoryMapper {

    public List<Category> list(Page page);

    public int total();  // 获取项目总数方法

    void add(Category category);

    void delete(int id);

    Category get(int id);  // 单独根据id获取信息

    void update(Category category);
}
