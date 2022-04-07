package ua.com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.foxminded.university.entity.TimeLesson;
import ua.com.foxminded.university.repository.TimeLessonRepository;
import ua.com.foxminded.university.service.TimeLessonService;

@Slf4j
@Service
public class TimeLessonServiceImpl implements TimeLessonService {

    private TimeLessonRepository repository;

    @Autowired
    public TimeLessonServiceImpl(TimeLessonRepository repository) {
        this.repository = repository;
    }

    public List<TimeLesson> findAll() {
        log.debug("Find all time lessons");
        return repository.findAll();
    }


    public Optional<TimeLesson> findById(Long id) {
        log.debug("Find time lesson with id = {}", id);
        return repository.findById(id);
    }

    public void add(TimeLesson timeLesson) {
        log.debug("Add time lesson");
        repository.save(timeLesson);
    }

    public void delete(TimeLesson timeLesson) {
        log.debug("Delete time lesson");
        repository.delete(timeLesson);
    }

}
