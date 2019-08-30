package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dao.StudeneMapper;
import com.example.springbootmybatis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: huangtf
 * @CreateDate: 2019/8/27 22:26
 */
@Service
public class StudentService {

    @Autowired
    StudeneMapper studeneMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public List<Student> index(){
        return  studeneMapper.index();
    }

    public int create(Student student){
        return  studeneMapper.create(student);
    }
    public int delete(int id){
        return  studeneMapper.delete(id);
    }

    public Student showByName(String name) {
        Student student = (Student)redisTemplate.opsForHash().get("student", name);
        String m = (String) stringRedisTemplate.opsForValue().get("mess");
        if(student == null){
            student = studeneMapper.findByName(name);
            stringRedisTemplate.opsForValue().set("mess", "message");
            redisTemplate.opsForValue().set("student1", student);
            redisTemplate.opsForHash().put("student", student.getName(), student);
        }

        return student;
    }
}
