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

    @NotBlank
    @Size(max=100, min=2)
    private String projectName;

    @NotBlank
    @Size(max=20, min=2)
    private String projectCode;

    @NotNull
    private UserDTO assignedManager;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotBlank
    @Size(max=100, min=2)
    private String projectDetail;

    @NotNull
    private Status projectStatus;

    @Pattern(regexp = "(?=.*\\d)")
    private int completeTaskCounts;

    @Pattern(regexp = "(?=.*\\d)")
    private int unfinishedTaskCounts;



}
