package ua.com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.foxminded.university.exception.DaoException;
import ua.com.foxminded.university.exception.ServiceException;
import ua.com.foxminded.university.entity.Teacher;
import ua.com.foxminded.university.repository.TeacherRepository;

@Slf4j
@Service
public class TeacherServiceImpl {

    private TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<Teacher> findAll() {
        log.debug("Find all teachers");
        return repository.findAll();
    }

    public Optional<Teacher> findById(Long id) {
        log.debug("Find teacher with id = {}", id);
        return repository.findById(id);
    }

    public void add(Teacher teacher) {
        log.debug("Add teacher with name - {}, last name - {}",
                teacher.getName(), teacher.getLastName());
        repository.save(teacher);
    }

    public void delete(Teacher teacher) {
        log.debug("Delete tacher with id = {}", teacher.getId());
        repository.delete(teacher);
    }

    public void addFromCourse(int idTeacher, int idCourse) {
        try {
            log.debug("Add teacher from course with tacher id = {}, course_id = {}",
                    idTeacher, idCourse);
            repository.addFromCourse(idTeacher, idCourse);
        } catch (DaoException e) {
            throw new ServiceException("No techer or course exists");
        }
    }

    public void deleteFromCourse(int idTeacher, int idCourse) {
        log.debug("Delete teacher from course with tacher id = {}, course_id = {}",
                idTeacher, idCourse);
        repository.deleteFromCourse(idTeacher, idCourse);
    }

}
