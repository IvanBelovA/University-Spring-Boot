package ua.com.foxminded.university.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "time_lesson")
public class TimeLesson {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "times")
    private LocalDateTime times;

    public TimeLesson() {
    }

}
