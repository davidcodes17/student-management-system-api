package com.davidcodes.StudentManagementSystems.services.studentService;

import com.davidcodes.StudentManagementSystems.configuration.Configuration;
import com.davidcodes.StudentManagementSystems.exceptions.ResourceNotFound;
import com.davidcodes.StudentManagementSystems.model.LoginStudent;
import com.davidcodes.StudentManagementSystems.model.Student;
import com.davidcodes.StudentManagementSystems.repositories.studentRepository.StudentRepository;
import com.davidcodes.StudentManagementSystems.responses.GoodReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final Configuration configuration;

    public StudentServiceImpl() {
        configuration = new Configuration();
    }

    @Override
    public String signup(Student student) {
        String uuid = UUID.randomUUID().toString();
        student.setStudentId(uuid);
        LoginStudent loginStudent = new LoginStudent(student.getEmail(), student.getMatrixNumber());
        Student found_student = studentRepository.findByEmailAndMatrixNumber(loginStudent.getEmail(), loginStudent.getMatrixNumber());
        boolean exsists = (found_student != null) ? true : false;
        if (exsists) {
            return "Student already Exsist for Student Email " + student.getEmail();
        }
        studentRepository.save(student);
        return "Account Created for Student " + student.getMatrixNumber();
    }

    @Override
    public Object login(LoginStudent loginStudent) {
        Student found_student = studentRepository.findByEmailAndMatrixNumber(loginStudent.getEmail(), loginStudent.getMatrixNumber());
        if(found_student==null){
            GoodReponse reponse = new GoodReponse("ERROR","STUDNET DOES NOT EXIST");
            return reponse;
        }
        return found_student;
    }

    @Override
    public String updateStudent(Student student, String id) {
        Student found_student = studentRepository.findById(Long.parseLong(id)).orElseThrow(()-> new ResourceNotFound("Student Not Found"));
        found_student.setEmail(student.getEmail());
        found_student.setDepartment(student.getDepartment());
        found_student.setFullName(student.getFullName());
        found_student.setMatrixNumber(student.getMatrixNumber());
        found_student.setPhoneNumber(student.getPhoneNumber());
        studentRepository.save(found_student);
        return "Studnent Updated Successfully";
    }

    @Override
    public String deleteStudent(String id) {
        Student found_student = studentRepository.findById(Long.parseLong(id)).orElseThrow(()-> new ResourceNotFound("Student Not Found"));
        studentRepository.delete(found_student);
        return "Student Deleted Successfully";
    }

    @Override
    public Student getStudentById(String studentId) {
        Student found_student = studentRepository.findById(Long.parseLong(studentId)).orElseThrow(()-> new ResourceNotFound("Student Not Found"));
        return found_student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
}
