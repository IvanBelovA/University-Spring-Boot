package ua.com.foxminded.university.repository;

import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.entity.Group;

@Repository
public interface GroupRepository extends GenericRepository<Group>{

    Group findGroupStudents(Group group);

}
