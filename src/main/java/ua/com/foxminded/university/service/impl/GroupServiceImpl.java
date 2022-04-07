package ua.com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.foxminded.university.entity.Group;
import ua.com.foxminded.university.repository.GroupRepository;

@Slf4j
@Service
public class GroupServiceImpl {

    private GroupRepository repository;
    
    @Autowired
    public GroupServiceImpl(GroupRepository repository) {
        this.repository = repository;
    }

    public List<Group> findAll() {
        log.debug("Find all groups");
        return repository.findAll();
    }

    public Optional<Group> findById(Long id) {
        log.debug("Find group with id = {}", id);
        return repository.findById(id);
    }

    public void add(Group group) {
        log.debug("Add group with name - {}", group.getGroupName());
        repository.save(group);
    }

    public void delete(Group group) {
        log.debug("Delete group with id = {}", group.getId());
        repository.delete(group);
    }

    public Group findGroupStudents(Group group) {
        log.debug("Fing all students related group with id = {}", group.getId());
        return repository.findGroupStudents(group);
    }

}
