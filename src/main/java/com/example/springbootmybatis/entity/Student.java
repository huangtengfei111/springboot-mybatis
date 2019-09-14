package com.example.springbootmybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.annotation.Documented;
import java.util.Comparator;
import java.util.Objects;

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
    Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Student) {
            Student student = (Student) obj;

            // 比较每个属性的值 一致时才返回true
            if (student.name.equals(this.name) && student.age.equals(this.age))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        return name.hashCode() * age.hashCode();
    }


    // Comparator接口可以实现自定义排序，实现Comparator接口时，要重写compare方法：
//int compare(Object o1, Object o2) 返回一个基本类型的整型
//如果要按照升序排序,则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
//如果要按照降序排序,则o1 小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
//    @Override
    public int compare(Student o1, Student o2) {
        if (o1.equals(o2)) {
            return 0;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        } else if (o1.getAge() == o2.getAge()) {
            int f = o1.getName().compareTo(o2.getName());
            if (f < 0) {
                return -1;
            }
            return 0;
        } else {
            return 1;
        }
    }
}
