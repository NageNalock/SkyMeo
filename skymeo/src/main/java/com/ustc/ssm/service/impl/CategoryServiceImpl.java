package com.ustc.ssm.service.impl;

import com.ustc.ssm.mapper.CategoryMapper;
import com.ustc.ssm.pojo.Category;
import com.ustc.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    /*
    * @Autowired是用在JavaBean中的注解，通过byType形式，用来给指定的字段或方法注入所需的外部资源。
    *
    * 通过自动装配@Autowired引入CategoryMapper ，在list方法中调用CategoryMapper 的list方法.
    * **/

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }
}
