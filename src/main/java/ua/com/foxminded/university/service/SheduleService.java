package ua.com.foxminded.university.service;

import java.util.List;

import ua.com.foxminded.university.entity.Shedule;
import ua.com.foxminded.university.entity.Student;
import ua.com.foxminded.university.entity.Teacher;

public interface SheduleService {

    List<Shedule> findAll();
    Shedule findById(Shedule shedule);
    void add(Shedule shedule);
    void delete(Shedule shedule);
    List<Shedule> getSheduleTeacher(Teacher teacher);
    List<Shedule> getSheduleStudent(Student student);
}
