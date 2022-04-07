package ua.com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.foxminded.university.entity.ClassRoom;
import ua.com.foxminded.university.repository.ClassRoomRepository;

@Slf4j
@Service
public class ClassRoomServiceImpl {

    private ClassRoomRepository repository;

    @Autowired
    public ClassRoomServiceImpl(ClassRoomRepository repository) {
        this.repository = repository;
    }

    public List<ClassRoom> findAll() {
        log.debug("Finding all class room");
        return repository.findAll();
    }

    public Optional<ClassRoom> findById(Long id) {
        log.debug("Find class room with id = {}", id);
        return repository.findById(id);
    }

    public void add(ClassRoom classRoom) {
        log.debug("Add class room with number - {}, capacity - {}",
                classRoom.getNumber(), classRoom.getCapacity());
        repository.save(classRoom);

    }

    public void delete(ClassRoom classRoom) {
        log.debug("Delete class room with id = {}", classRoom.getId());
        repository.delete(classRoom);
    }

}
