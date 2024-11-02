package com.ticketing.controller;

import com.ticketing.dto.TaskDTO;
import com.ticketing.service.ProjectService;
import com.ticketing.service.TaskService;
import com.ticketing.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public TaskController(UserService userService, ProjectService projectService, TaskService taskService) {
        this.userService = userService;
        this.projectService=projectService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
   public String createTask(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("employees",userService.findEmployees());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("tasks",taskService.findAll());

       return "task/create";
   }

   @PostMapping("/create")
    public String insertTask(@ModelAttribute("task") TaskDTO task){

        taskService.save(task);

        return "redirect:/task/create";
   }
}
