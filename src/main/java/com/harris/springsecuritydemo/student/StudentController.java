package com.harris.springsecuritydemo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static List<Student> studentList;

    @PostConstruct
    public void init(){
        Student s1 = new Student(1, "James Bond");
        Student s2 = new Student(2, "Maria Jones");
        Student s3 = new Student(3, "Anna Smith");
        studentList = Arrays.asList(s1,s2,s3);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return studentList.stream().filter(s ->s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student with given ID " + studentId + " does not exist"));
    }

}
