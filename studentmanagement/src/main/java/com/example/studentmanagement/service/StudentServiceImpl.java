package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudent() {
        return ImmutableList.copyOf(studentRepository.findAll());
    }

    @Override
    public Boolean saveStudent(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }
}
