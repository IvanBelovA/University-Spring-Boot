package ua.com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.foxminded.university.entity.Course;
import ua.com.foxminded.university.repository.CourseRepository;

@Slf4j
@Service
public class CourseServiceImpl {

    private CourseRepository repository;

    @Autowired
    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> findAll() {
        log.debug("Find all course");
        return repository.findAll();
    }

    public Optional<Course> findById(Long id) {
        log.debug("Find course with id = {}", id);
        return repository.findById(id);
    }

    public void add(Course course) {
        log.debug("Add course with course name - {}", course.getCourseName());
        repository.save(course);
    }

    public void delete(Course course) {
        log.debug("Delete course with id = {}", course.getId());
        repository.delete(course);
    }

    public Course findCourseStudents(Course course) {
        log.debug("Find all students related course");
        return repository.findCourseStudents(course);
    }

    public Course findCourseTeachers(Course course) {
        log.debug("Find all teacher related course");
        return repository.findCourseTeachers(course);
    }

}
