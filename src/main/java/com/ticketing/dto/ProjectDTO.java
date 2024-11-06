package com.ticketing.dto;

import com.ticketing.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    public ProjectDTO(String projectName, String projectCode, UserDTO assignedManager, LocalDate startDate, LocalDate endDate, String projectDetail, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
    }

    @NotBlank(message = "Project Name is a required field")
    private String projectName;

    @NotBlank(message = "Project Code is a required field")
    private String projectCode;

    @NotNull(message = "Please select a manager")
    private UserDTO assignedManager;

    @NotNull(message="Please select a Start Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message="Please select an End Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotBlank(message = "Project Detail is a required field")
    @Size(min=2, max=500,message = "Detail should be at least 2 and max 500 characters long")
    private String projectDetail;


    private Status projectStatus;
    private int completeTaskCounts;
    private int unfinishedTaskCounts;



}
