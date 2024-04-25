package com.davidcodes.StudentManagementSystems.repositories.courseRepository;

import com.davidcodes.StudentManagementSystems.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    Optional<Course> findCourseByCourseId(String courseId);

    List<Course> findCourseByDepartment(String department);


}
