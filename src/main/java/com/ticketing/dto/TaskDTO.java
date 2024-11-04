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

    @NotNull
    @Pattern(regexp = "(?=.*\\d)")
    private Long id;

    @NotNull
    private ProjectDTO project;
    @NotNull
    private UserDTO assignedEmployee;

    @NotBlank
    @Size(max=50,min=2)
    private String taskSubject;

    @NotBlank
    @Size(max=500, min=2)
    private String taskDetail;

    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate assignedDate;

    @NotNull
    private Status taskStatus;

}
