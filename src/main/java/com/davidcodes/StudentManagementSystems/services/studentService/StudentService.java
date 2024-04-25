package com.davidcodes.StudentManagementSystems.services.studentService;


import com.davidcodes.StudentManagementSystems.model.LoginStudent;
import com.davidcodes.StudentManagementSystems.model.Student;

import java.util.List;

public interface StudentService{

    public String signup(Student student);

    public Object login(LoginStudent student);

    public String updateStudent(Student student, String id);

    public String deleteStudent(String id);

    public Student getStudentById(String studentId);

    public List<Student> getAllStudents();

}
