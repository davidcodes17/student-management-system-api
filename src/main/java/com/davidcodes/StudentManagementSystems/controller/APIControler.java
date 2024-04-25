package com.davidcodes.StudentManagementSystems.controller;

import com.davidcodes.StudentManagementSystems.model.*;
//import com.davidcodes.StudentManagementSystems.services.courseService.CourseServiceImpl;
import com.davidcodes.StudentManagementSystems.services.courseService.CourseServiceImpl;
import com.davidcodes.StudentManagementSystems.services.studentService.StudentServiceImpl;
import com.davidcodes.StudentManagementSystems.services.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class APIControler {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user){
        return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> signup(@RequestBody LoginUser user){
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody LoginUser user, @PathVariable String userId){
        return new ResponseEntity<>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.signup(student), HttpStatus.OK);
    }

    @PostMapping("/student-login")
    public ResponseEntity<?> studentLogin(@RequestBody LoginStudent student){
        return new ResponseEntity<>(studentService.login(student),HttpStatus.OK);
    }

    @PutMapping("/student/{id}")
    public  ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable String id){
        return new ResponseEntity<>(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id){
        return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @PostMapping("/course")
    public ResponseEntity<?> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.createCourse(course),HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<?> getAllCourses(){
        return new ResponseEntity<>(courseService.fetchCourses(),HttpStatus.OK);
    }

    @PutMapping("/course/{courseId}")
    public ResponseEntity<?> updateCourse(@RequestBody Course course,@PathVariable String courseId){
        return new ResponseEntity<>(courseService.updateCourse(course,courseId),HttpStatus.OK);
    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable String courseId){
        return new ResponseEntity<>(courseService.deleteCourse(courseId),HttpStatus.OK);
    }

    @GetMapping("/course/{department}")
    public ResponseEntity<?> getCourseByDepartment(@PathVariable String department){
        return new ResponseEntity<>(courseService.fetchCourseByDepartment(department),HttpStatus.OK);
    }


}
