package ua.com.foxminded.university.repository;

import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.entity.Course;

@Repository
public interface CourseRepository extends GenericRepository<Course>{

    Course findCourseStudents(Course course);
    
    Course findCourseTeachers(Course course);
}
