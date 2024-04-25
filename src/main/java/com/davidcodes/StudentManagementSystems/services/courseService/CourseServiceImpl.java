package com.davidcodes.StudentManagementSystems.services.courseService;

import com.davidcodes.StudentManagementSystems.exceptions.ResourceNotFound;
import com.davidcodes.StudentManagementSystems.model.Course;
import com.davidcodes.StudentManagementSystems.repositories.courseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> fetchCourses() {
        return courseRepository.findAll();
    }

    @Override
    public String createCourse(Course course) {
        String uuid = UUID.randomUUID().toString();
        course.setCourseId(uuid);
        courseRepository.save(course);
        return "Course Saved Successfully";
    }

    @Override
    public String updateCourse(Course course, String courseId) {
        Course foundCourse = courseRepository.findCourseByCourseId(courseId).orElseThrow(()-> new ResourceNotFound("Course Not Found"));
        foundCourse.setCourseName(course.getCourseName());
        foundCourse.setCourseDocumentLink(course.getCourseDocumentLink());
        foundCourse.setDepartment(course.getDepartment());
        courseRepository.save(foundCourse);
        return "Course Updated Successfully";
    }

    @Override
    public String deleteCourse(String courseId) {
        Course foundCourse = courseRepository.findCourseByCourseId(courseId).orElseThrow(()-> new ResourceNotFound("Course Not Found"));
        courseRepository.delete(foundCourse);
        return null;
    }

    @Override
    public Course fetchCourseByCourseId(String courseId) {
        Course foundCourse = courseRepository.findCourseByCourseId(courseId).orElseThrow(()-> new ResourceNotFound("Course Not Found"));
        return foundCourse;
    }

    @Override
    public List<Course> fetchCourseByDepartment(String department) {
        return courseRepository.findCourseByDepartment(department);
    }
}
