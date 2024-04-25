package com.davidcodes.StudentManagementSystems.services.courseService;

import com.davidcodes.StudentManagementSystems.model.Course;

import java.util.List;

public interface CourseService {

    public List<Course> fetchCourses();

    public String createCourse(Course course);

    public String updateCourse(Course course,String courseId);

    public String deleteCourse(String courseId);

    public Course fetchCourseByCourseId(String courseId);

    public List<Course> fetchCourseByDepartment(String department);

}
