package com.example.demo_c12.service;



import com.example.demo_c12.dto.StudentDto;
import com.example.demo_c12.entity.Student;

import java.util.List;

public interface IStudentService {
    List<StudentDto> findAll();
    List<Student> search(String name, int classId);
    boolean add(Student student);
    boolean deleteById(int id);
}
