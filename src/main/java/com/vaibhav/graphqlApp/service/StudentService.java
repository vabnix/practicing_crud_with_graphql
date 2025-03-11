package com.vaibhav.graphqlApp.service;

import com.vaibhav.graphqlApp.dto.GraphQLPageRequest;
import com.vaibhav.graphqlApp.dto.PageInfo;
import com.vaibhav.graphqlApp.dto.Student;
import com.vaibhav.graphqlApp.dto.StudentPage;
import com.vaibhav.graphqlApp.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student addStudent(Student student) {
        // Ensure this is a new student
        student.setId(null);
        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudent(Student student) {
        if (student.getId() == null) {
            throw new IllegalArgumentException("Student ID must be provided for updates");
        }

        Student existingStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + student.getId()));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setClassName(student.getClassName());
        existingStudent.setSection(student.getSection());
        existingStudent.setRollNumber(student.getRollNumber());

        return studentRepository.save(existingStudent);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));
    }


    public StudentPage studentPage(GraphQLPageRequest pageRequest) {
        if (pageRequest == null) {
            pageRequest = new GraphQLPageRequest();
        }

        int page = pageRequest.getPage() != null ? pageRequest.getPage() : 0;
        int size = pageRequest.getSize() != null ? pageRequest.getSize() : 10;

        Pageable pageable = org.springframework.data.domain.PageRequest.of(page, size);

        // Fetch data from repository
        Page<Student> studentPage = studentRepository.findAll(pageable);

        // Create and populate PageInfo
        PageInfo pageInfo = new PageInfo();
        pageInfo.setHasNextPage(studentPage.hasNext());
        pageInfo.setHasPreviousPage(studentPage.hasPrevious());
        pageInfo.setTotalElements(studentPage.getTotalElements());
        pageInfo.setTotalPages(studentPage.getTotalPages());

        // Create and populate StudentPage
        StudentPage result = new StudentPage();
        result.setContent(studentPage.getContent());  // Never null, at worst empty list
        result.setPageInfo(pageInfo);  // Never null

        return result;
    }
}
