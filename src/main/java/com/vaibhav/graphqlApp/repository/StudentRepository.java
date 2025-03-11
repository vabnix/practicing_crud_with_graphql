package com.vaibhav.graphqlApp.repository;

import com.vaibhav.graphqlApp.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
