package ua.com.foxminded.university.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.entity.Teacher;

@Repository
public interface TeacherRepository extends GenericRepository<Teacher> {

    @Modifying
    @Query(value = "INSERT INTO teachers_courses(teacher_id, course_id) VALUES(:idTeacher, :idCourse)",
            nativeQuery = true)
    void addFromCourse(@Param("idTeacher") int idTeacher, @Param("idCourse")int idCourse);

    @Modifying
    @Query(value = "DELETE FROM teachers_courses WHERE teacher_id = ? AND course_id = ?",
            nativeQuery = true)
    void deleteFromCourse(@Param("idTeacher") int idTeacher, @Param("idCourse")int idCourse);

    @Query(value = "SELECT t.id, t.name, t.last_name, c.id AS course_id, c.course_name "
            + "FROM teachers AS t "
            + "JOIN teachers_courses AS tc ON tc.teacher_id = t.id "
            + "JOIN courses AS c ON c.id = tc.course_id "
            + "WHERE t.id = :idTeacher",
            nativeQuery = true)
    Teacher findCoursesTeacher(@Param("idTeacher") int idTeacher);

}
