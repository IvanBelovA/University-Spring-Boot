package ua.com.foxminded.university.service;

import java.util.List;
import java.util.Optional;

import ua.com.foxminded.university.entity.TimeLesson;

public interface TimeLessonService {

    List<TimeLesson> findAll();
    Optional<TimeLesson> findById(Long id);
    void add(TimeLesson timeLesson);
    void delete(TimeLesson timeLesson);
}
