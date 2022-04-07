package ua.com.foxminded.university.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lessons")
@Data
public class Lesson {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private TimeLesson timeLesson;

    public Lesson() {
    }

}
