package com.vaibhav.graphqlApp.controller;

import com.vaibhav.graphqlApp.dto.Student;
import com.vaibhav.graphqlApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @MutationMapping
    public Student addStudent(@Argument Student student) {
        return studentService.addStudent(student);
    }

    @MutationMapping
    public Student updateStudent(@Argument Student student) {
        return studentService.updateStudent(student);
    }

    @QueryMapping
    public List<Student> students() {
        return studentService.getStudents();
    }

    @QueryMapping
    public Student studentById(@Argument Integer id) {
        return studentService.getStudentById(id);
    }


}
