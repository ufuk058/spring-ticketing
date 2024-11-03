package com.ticketing.service;

import com.ticketing.dto.ProjectDTO;
import com.ticketing.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CRUDService<ProjectDTO,String > {

    void complete(ProjectDTO project);

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);
}
