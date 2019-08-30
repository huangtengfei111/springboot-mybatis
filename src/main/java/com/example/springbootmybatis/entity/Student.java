package com.example.springbootmybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.annotation.Documented;

/**
 * @Description: java类作用描述
 * @Author: huangtf
 * @CreateDate: 2019/8/27 22:22
 */
@Getter
@Setter
public class Student implements Serializable {
    int id;
    String name;
    int age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
