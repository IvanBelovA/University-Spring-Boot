package ua.com.foxminded.university.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "class_room")
@Data
public class ClassRoom {

    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "number")
    private int number;
    
    @Column(name = "capacity")
    private int capacity;

    public ClassRoom() {
    }

}
