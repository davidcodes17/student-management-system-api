package com.davidcodes.StudentManagementSystems.repositories.studentRepository;

import com.davidcodes.StudentManagementSystems.model.LoginStudent;
import com.davidcodes.StudentManagementSystems.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findStudentsByDepartment(String department);

    Student findByEmailAndMatrixNumber(String email,String matrixNumber);

}
