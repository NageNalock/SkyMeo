package com.ustc.ssm.pojo;
/*
* 目录
*
* 用于查询
* **/
public class Category {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    private int id;
    private String name;
}
