package ua.com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.foxminded.university.entity.Shedule;
import ua.com.foxminded.university.entity.Student;
import ua.com.foxminded.university.entity.Teacher;
import ua.com.foxminded.university.exception.DaoException;
import ua.com.foxminded.university.exception.ServiceException;
import ua.com.foxminded.university.repository.SheduleRepository;

@Slf4j
@Service
public class SheduleServiceImpl {

    private SheduleRepository repository; 

    @Autowired
    public SheduleServiceImpl(SheduleRepository repository) {
        this.repository = repository;
    }

    public List<Shedule> findAll() {
        log.debug("Find all shedules");
        return repository.findAll();
    }

    public Optional<Shedule> findById(Long id) {
        log.debug("Find shedule with id = {}", id);
        return repository.findById(id);
    }

    public void add(Shedule shedule) {
        try {
            log.debug("Add shedule");
            repository.save(shedule);
        } catch (DaoException e) {
            throw new ServiceException("Invalid input data");
        }
    }

    public void delete(Shedule shedule) {
        log.debug("Delete shedule with id = {}", shedule.getId());
        repository.delete(shedule);
    }

    public List<Shedule> getSheduleTeacher(Teacher teacher) {
        log.debug("Find all shedules related teacher with id = {}", teacher.getId());
        return repository.getSheduleTeacher(teacher);
    }

    public List<Shedule> getSheduleStudent(Student student) {
        log.debug("Find shedules related student with id = {}", student.getId());
        return repository.getSheduleStudent(student);
    }

}
