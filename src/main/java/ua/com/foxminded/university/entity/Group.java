package ua.com.foxminded.university.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "groups")
@Data
public class Group {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<Student> student;

    public Group() {
    }

}
