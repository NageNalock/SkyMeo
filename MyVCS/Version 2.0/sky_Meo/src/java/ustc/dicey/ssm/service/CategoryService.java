package ustc.dicey.ssm.service;

import ustc.dicey.ssm.pojo.Category;
import ustc.dicey.ssm.util.Page;

import java.util.List;

public interface CategoryService {

    // 分页逻辑重写,去掉该方法
    // List<Category> list(Page page);

    // 分页逻辑重写,去掉该方法
    // int total();

    // 新增list()
    List<Category> list();

    void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);
}
