package ua.com.foxminded.university.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.entity.Shedule;
import ua.com.foxminded.university.entity.Student;
import ua.com.foxminded.university.entity.Teacher;

@Repository
public interface SheduleRepository extends GenericRepository<Shedule> {

    List<Shedule> getSheduleTeacher(Teacher teacher);

    List<Shedule> getSheduleStudent(Student student);

}
