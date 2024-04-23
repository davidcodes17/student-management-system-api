package com.davidcodes.StudentManagementSystems.repositories.studentRepository;

import com.davidcodes.StudentManagementSystems.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findStudentsByDepartment(String department);

}
