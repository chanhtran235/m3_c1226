package com.example.demo_c12.repository;



import com.example.demo_c12.dto.StudentDto;
import com.example.demo_c12.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDto> findAll();
    List<StudentDto> search(String name, String classId);
    List<StudentDto> search(String name);
    boolean add(Student student);
    boolean deleteById(int id);
}
