package ua.com.foxminded.university.repository;

import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.entity.Student;

@Repository
public interface StudentRepository extends GenericRepository<Student> {

    void assignFromCourse(int studentId, int courseId);

    void deleteFromCourse(int studentId, int courseId);

    void addFromGroup(int studentId, int groupId);

    void deleteFromGroup(int studentId);

    Student findCoursesStudent(Student student);

}
