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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {


    private Long id;

    @NotNull(message = "Please select a Project")
    private ProjectDTO project;

    @NotNull(message = "Please select an Employee")
    private UserDTO assignedEmployee;

    @NotBlank(message = "Task Subject is a required field")
    private String taskSubject;

    @NotBlank(message = "Task Detail is a required field")
    private String taskDetail;

    private LocalDate assignedDate;
    private Status taskStatus;

}
