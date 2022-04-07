package ua.com.foxminded.university.service;

import java.util.List;

import ua.com.foxminded.university.entity.Lesson;

public interface LessonService {

    List<Lesson> findAll();
    Lesson findById(int id);
    void add(Lesson lesson);
    void delete(Lesson lesson);
}
