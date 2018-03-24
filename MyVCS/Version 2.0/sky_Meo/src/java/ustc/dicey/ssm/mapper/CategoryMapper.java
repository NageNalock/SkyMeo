package ustc.dicey.ssm.mapper;

import ustc.dicey.ssm.pojo.Category;
import ustc.dicey.ssm.util.Page;

import java.util.List;

public interface CategoryMapper {

    // 分页逻辑重写,去掉该方法
    // List<Category> list(Page page);

    // 分页逻辑重写,去掉该方法
    // int total();  // 获取项目总数方法

    // 新分页方法,不再依靠参数
    List<Category> list();

    void add(Category category);

    void delete(int id);

    Category get(int id);  // 单独根据id获取信息

    void update(Category category);
}
