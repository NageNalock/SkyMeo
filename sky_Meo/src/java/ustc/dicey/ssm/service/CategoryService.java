package ustc.dicey.ssm.service;

import ustc.dicey.ssm.pojo.Category;
import ustc.dicey.ssm.util.Page;

import java.util.List;

public interface CategoryService {
    public List<Category> list(Page page);
    int total();

    void add(Category category);

    void delete(int id);
}
