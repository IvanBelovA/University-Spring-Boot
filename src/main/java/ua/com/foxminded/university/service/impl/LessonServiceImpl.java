package ua.com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.foxminded.university.entity.Lesson;
import ua.com.foxminded.university.repository.LessonRepository;

@Slf4j
@Service
public class LessonServiceImpl {

    private LessonRepository repository;

    @Autowired
    public LessonServiceImpl(LessonRepository repository) {
        this.repository = repository;
    }

    public List<Lesson> findAll() {
        log.debug("Find all lessons");
        return repository.findAll();
    }

    public Optional<Lesson> findById(Long id) {
        log.debug("Find lesson with id = {}", id);
        return repository.findById(id);
    }

    public void add(Lesson lesson) {
        log.debug("Add lesson with number - {}", lesson.getNumber());
        repository.save(lesson);
    }

    public void delete(Lesson lesson) {
        log.debug("Delete lesson with id = {}", lesson.getId());
        repository.delete(lesson);
    }

}
