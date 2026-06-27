package com.example.demo_c12.repository;



import com.example.demo_c12.entity.ClassCG;

import java.util.List;

public interface IClassRepository {
    List<ClassCG> findAll();
}
