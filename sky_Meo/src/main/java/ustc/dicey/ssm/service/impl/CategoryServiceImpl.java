package ustc.dicey.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ustc.dicey.ssm.mapper.CategoryMapper;
import ustc.dicey.ssm.pojo.Category;
import ustc.dicey.ssm.pojo.CategoryExample;
import ustc.dicey.ssm.service.CategoryService;
import ustc.dicey.ssm.util.Page;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryMapper categoryMapper;

//    @Override
//    public List<Category> list(Page page) {
//        // System.out.println("CategoryServiceImpl");
//        return categoryMapper.list(page);
//    }
//
//    @Override
//    public int total() {
//        return categoryMapper.total();
//    }


    @Override
    public List<Category> list() {
        // 传递一个example对象，这个对象指定按照id倒排序来查询
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
