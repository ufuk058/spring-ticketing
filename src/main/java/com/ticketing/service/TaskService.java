package com.ticketing.service;

import com.ticketing.dto.TaskDTO;
import com.ticketing.enums.Status;

import java.util.List;

public interface TaskService extends CRUDService<TaskDTO,Long> {

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    List<TaskDTO> findAllTasksByStatus(Status status);

    void updateStatus(TaskDTO task);
}
