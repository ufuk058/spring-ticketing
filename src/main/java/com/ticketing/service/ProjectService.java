package com.ticketing.service;

import com.ticketing.dto.ProjectDTO;

public interface ProjectService extends CRUDService<ProjectDTO,String > {

    void complete(ProjectDTO project);

}
