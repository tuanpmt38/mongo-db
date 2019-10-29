package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentEditDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository repository;

  @Override
  public Student save(StudentDto studentDto) {
    Student student = new Student();
    student.setUserName(studentDto.getUserName());
    student.setLop(studentDto.getLop());
    student.setSchool(studentDto.getSchool());
    repository.save(student);
    return student;
  }


  @Override
  public List<Student> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Student> findById(String id) {
    return repository.findById(id);
  }

}
