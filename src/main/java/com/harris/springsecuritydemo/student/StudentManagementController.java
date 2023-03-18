package com.harris.springsecuritydemo.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {

    private static List<Student> studentList;

    @PostConstruct
    public void init(){
        Student s1 = new Student(1, "James Bond");
        Student s2 = new Student(2, "Maria Jones");
        Student s3 = new Student(3, "Anna Smith");
        studentList = Arrays.asList(s1,s2,s3);
    }

    // hasRole(ROLE_) , hasAnyRole(ROLE_), hasAuthority('permission'), hasAnyAuthority('permission')
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        System.out.println("GET");
        return studentList;
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("POST");
        System.out.println(student.toString());
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public  void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("DELETE");
        System.out.println(studentId.toString());
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println("PUT");
        System.out.println(String.format("id of %s is getting updated to %s ", student.toString(), studentId));
    }
}
