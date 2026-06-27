package com.example.demo_c12.service;



import com.example.demo_c12.dto.StudentDto;
import com.example.demo_c12.entity.Student;
import com.example.demo_c12.repository.IStudentRepository;
import com.example.demo_c12.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> search(String name, int classId) {
        return studentRepository.search(name,classId);
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }

    @Override
    public boolean deleteById(int id) {
        return studentRepository.deleteById(id);
    }
}
