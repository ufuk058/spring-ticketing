package com.ticketing.service.impl;

import com.ticketing.dto.ProjectDTO;
import com.ticketing.enums.Status;
import com.ticketing.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO project) {
        if(project.getProjectStatus()==null){
            project.setProjectStatus(Status.OPEN);
        }
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String projectCode) {

        super.deleteById(projectCode);
    }

    @Override
    public void update(ProjectDTO project) {

        if(project.getProjectStatus()==null){
            project.setProjectStatus(findById(project.getProjectCode()).getProjectStatus());
        }
        super.update(project.getProjectCode(),project);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
    }
}
