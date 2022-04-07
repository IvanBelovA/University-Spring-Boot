package ua.com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.foxminded.university.entity.Student;
import ua.com.foxminded.university.exception.DaoException;
import ua.com.foxminded.university.exception.ServiceException;
import ua.com.foxminded.university.repository.StudentRepository;
import ua.com.foxminded.university.service.StudentService;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() {
        log.debug("Find all students");
        return repository.findAll();
    }

    public Optional<Student> findById(Long id) {
        log.debug("Find student with id = {}", id);
        return repository.findById(id);
    }

    public void add(Student student) {
        log.debug("Add student witth name - {}, last name - {}",
                student.getFirstName(), student.getLastName());
        repository.save(student);
    }

    public void delete(Student student) {
        log.debug("Delete student with id = {}", student.getId());
        repository.delete(student);
    }

    public void assignFromCourse(int studentId, int courseId) {
        try {
            log.debug("Assign student from course with student_id = {}, course_id = {}",
                    studentId, courseId);
            repository.assignFromCourse(studentId, courseId);
        } catch (DaoException e) {
            throw new ServiceException("No student or course exists");
        }
    }

    public void deleteFromCourse(int studentId, int courseId) {
        log.debug("Delete student from course with student_id = {}, course_id = {}",
                studentId, courseId);
        repository.deleteFromCourse(studentId, courseId);
    }

    public void addFromGroup(int studentId, int groupId) {
        try {
            log.debug("Add student from group with student_id = {}, group_id = {}",
                    studentId, groupId);
            repository.addFromGroup(studentId, groupId);
        } catch (DaoException e) {
            throw new ServiceException("No group exists");
        }
    }

    public void deleteFromGroup(int studentId) {
        log.debug("Delete student from group with student_id = {}",
                studentId);
        repository.deleteFromGroup(studentId);
    }

    public Student findCoursesStudent(Student student) {
        log.debug("Find courses related student with id = {}", student.getId());
        return repository.findCoursesStudent(student);
    }

}
