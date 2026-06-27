package com.example.demo_c12.service;

import com.example.demo_c12.entity.ClassCG;
import com.example.demo_c12.repository.ClassRepository;
import com.example.demo_c12.repository.IClassRepository;
import java.util.List;

public class ClassService implements IClassService {
    private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<ClassCG> findAll() {
      return classRepository.findAll();
    }
}
