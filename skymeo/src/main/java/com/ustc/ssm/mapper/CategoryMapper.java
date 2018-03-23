package com.ustc.ssm.mapper;

/*
* 只包含一个方法:
* 查询
* **/

import com.ustc.ssm.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryMapper {
    List<Category> list();
}
