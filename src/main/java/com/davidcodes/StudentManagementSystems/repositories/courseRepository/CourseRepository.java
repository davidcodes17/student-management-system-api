package com.davidcodes.StudentManagementSystems.repositories.courseRepository;

import com.davidcodes.StudentManagementSystems.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    Course findCourseByCourseId(String courseId);

    List<Course> findCourseByDepartment(String department);


}
