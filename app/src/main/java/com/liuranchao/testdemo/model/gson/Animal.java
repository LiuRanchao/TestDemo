package com.liuranchao.testdemo.model.gson;

import com.liuranchao.testdemo.model.BaseModel;

/**
 * Description: 动物基类
 *
 * @author liuranchao
 * @date 15/11/5 上午12:08
 */
public abstract class Animal implements BaseModel{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
