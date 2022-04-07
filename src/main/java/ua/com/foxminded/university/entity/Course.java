package ua.com.foxminded.university.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "course_name")
    private String courseName;
    
    @ManyToMany(mappedBy = "courses")
    private List<Student> student;
    
    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;

    public Course() {
    }

}
