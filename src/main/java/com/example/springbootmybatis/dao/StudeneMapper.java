package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: huangtf
 * @CreateDate: 2019/8/27 22:26
 */
@Mapper
@Repository
public interface StudeneMapper {

    @Select("SELECT * FROM student")
    public List<Student> index();

    @Options(useGeneratedKeys=true,keyProperty="id")
    @Insert("insert into student(name,age) values(#{name}, #{age})")
    public int create(Student student);

    @Delete("delete from student where id=(#{id})")
    public int delete(int id);

    @Select("SELECT * FROM student where name = (#{name})")
    Student findByName(@Param("name") String name);
}
