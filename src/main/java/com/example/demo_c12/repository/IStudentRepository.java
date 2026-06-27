package com.example.demo_c12.repository;



import com.example.demo_c12.dto.StudentDto;
import com.example.demo_c12.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDto> findAll();
    List<Student> search(String name, int classId);
    boolean add(Student student);
    boolean deleteById(int id);
}
