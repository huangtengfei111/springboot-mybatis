package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Student;
import com.example.springbootmybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: huangtf
 * @CreateDate: 2019/8/27 22:21
 */

@RestController
public class MysqlController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> index(){
        return  studentService.index();
    }

    @PostMapping("/students")
    public int create(@RequestBody Student student){
        return  studentService.create(student);
    }

    @PostMapping("/students/find-by-name")
    public Student showByName(@RequestBody Student student){

        return  studentService.showByName(student.getName());

    }

    @DeleteMapping("/students/{id}")
    public int delete(@PathVariable int id){
        return  studentService.delete(id);
    }
}
