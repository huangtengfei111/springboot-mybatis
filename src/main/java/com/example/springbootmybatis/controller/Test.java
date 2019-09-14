package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Student;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @Description: set对象去重，重写hashcode,equal方法, 对象是自定义排序重写Comparator的compare
 * @Author: huangtf
 * @CreateDate: 2019/9/14 12:13
 */
public class Test {
    public static void main(String[] args) {
        Set<Student> s = new HashSet();
        Student stu = new Student();
        stu.setName("zs");
        stu.setAge(11);
        stu.setId(1);
        s.add(stu);
        //自定义去重，name,age都相等认为相等，只存一个
        stu.setName("zs");
        stu.setAge(11);
        stu.setId(6);

        Student stu2 = new Student();
        stu2.setName("zs");
        stu2.setAge(12);
        stu2.setId(2);

        Student stu3 = new Student();
        stu3.setName("ls");
        stu3.setAge(12);
        stu3.setId(2);
        s.add(stu);
        s.add(stu2);
        s.add(stu3);
        //自定义排序

        for (Student ss : s) {
            System.out.println(ss);
        }
        System.out.println("===================");
        Comparator comparator = comparator();

        List list = new ArrayList<>(s);
        Collections.sort(list, comparator);
        LinkedHashSet<Student> lhs = new LinkedHashSet(list);
        for (Student ss : lhs) {
            System.out.println(ss);
        }
        System.out.println("===================");
        List<Student> list2 = new ArrayList<>();
        list2.addAll(s);
        Collections.sort(list2, comparator);
        for (Student ss : list2
        ) {
            System.out.println(ss);
        }
        System.out.println("===================");
    }

    public static Comparator comparator(){
        Comparator comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.equals(o2)) {
                    return 0;
                } else if (o1.getAge() < o2.getAge()) {
                    return 1;
                } else if (o1.getAge() == o2.getAge()) {
                    int f = o1.getName().compareTo(o2.getName());
                    if (f < 0) {
                        return -1;
                    }
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        return comparator;
    }
}
