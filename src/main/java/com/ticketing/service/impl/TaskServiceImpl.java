package com.ticketing.service.impl;

import com.ticketing.dto.TaskDTO;
import com.ticketing.enums.Status;
import com.ticketing.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {


    @Override
    public TaskDTO save(TaskDTO task) {

        if(task.getTaskStatus()==null){
            task.setTaskStatus(Status.OPEN);

        }
        if(task.getAssignedDate()==null){
            task.setAssignedDate(LocalDate.now());

        }
        if(task.getId()==null){
            task.setId(UUID.randomUUID().getMostSignificantBits());
        }
        return super.save(task.getId(),task);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }



    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void update(TaskDTO task) {

        task.setTaskStatus(findById(task.getId()).getTaskStatus());
        task.setAssignedDate(findById(task.getId()).getAssignedDate());
        super.update(task.getId(),task);
    }


    @Override
    public List<TaskDTO> findAllTasksByStatusIsNot(Status status) {
        return findAll().stream().filter(task -> task.getTaskStatus()!= status).collect(Collectors.toUnmodifiableList());

    }

    @Override
    public List<TaskDTO> findAllTasksByStatusIs(Status status) {
        return findAll().stream().filter(task -> task.getTaskStatus()==status).collect(Collectors.toUnmodifiableList());
    }
}
