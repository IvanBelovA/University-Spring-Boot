package ua.com.foxminded.university.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "teachers_courses",
            joinColumns = { @JoinColumn(name = "teacher_id")},
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
            )
    private List<Course> courses;

    public Teacher() {
    }

}
