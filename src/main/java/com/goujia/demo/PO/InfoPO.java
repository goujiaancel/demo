package com.goujia.demo.PO;

import com.google.gson.Gson;

public class InfoPO {

    private Integer id;
    private String name;
    private Integer age;

    public InfoPO(String name) {
        this.name = name;
    }

    public InfoPO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
