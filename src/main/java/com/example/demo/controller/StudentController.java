package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentEditDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StudentController {

  @Autowired
  StudentService studentService;

  @Autowired
  StudentRepository studentRepository;

  @PostMapping(value = "student")
  public ResponseEntity<Student> createStudent(@RequestBody StudentDto dto) {
    Student student = studentService.save(dto);
    return ResponseEntity.ok(student);
  }

  @GetMapping(value = "students")
  public List<Student> listStudents() {
    return studentService.findAll();
  }

  @GetMapping(value = "student/{id}")
  public Optional<Student> getStudent(@PathVariable("id") String id) {
    return studentService.findById(id);
  }

  @DeleteMapping(value ="student/{id}")
  public void deleteStudent(@PathVariable ("id") String id){
    Optional<Student> student = studentService.findById(id);
    studentRepository.delete(student.get());
  }
}
