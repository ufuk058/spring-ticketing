package com.ticketing.controller;

import com.ticketing.dto.TaskDTO;
import com.ticketing.enums.Status;
import com.ticketing.service.ProjectService;
import com.ticketing.service.TaskService;
import com.ticketing.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String insertTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model){

       if(bindingResult.hasErrors()){
           model.addAttribute("employees",userService.findEmployees());
           model.addAttribute("projects",projectService.findAll());
           model.addAttribute("tasks",taskService.findAll());
           return "/task/create";
       }
        taskService.save(task);

        return "redirect:/task/create";
   }

   @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);

        return "redirect:/task/create";
   }

   @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model){

        model.addAttribute("task",taskService.findById(id));
       model.addAttribute("employees",userService.findEmployees());
       model.addAttribute("projects",projectService.findAll());
       model.addAttribute("tasks",taskService.findAll());
        return "/task/update";
   }

//   @PostMapping("/update/{taskId}")
//    public String updateTask(@PathVariable("taskId") Long taskId, @ModelAttribute("task") TaskDTO task){
//
//        task.setId(taskId);
//        taskService.update(task);
//        return "redirect:/task/create";
//   }



    @PostMapping("/update/{id}")
    public String updateTask( @ModelAttribute("task") TaskDTO task){

        taskService.update(task);
        return "redirect:/task/create";
    }


    @GetMapping("employee/pending-tasks")
    public String employeePendingTask(Model model){

        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));
        return "task/pending-tasks";
    }

    @GetMapping("employee/archive")
    public String archivedTasks(Model model){
        model.addAttribute("tasks", taskService.findAllTasksByStatus(Status.COMPLETE));

        return "task/archive";
    }

    @GetMapping("employee/edit/{id}")
    public String employeeEditTask(@PathVariable("id") Long id, Model model){

        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));
        model.addAttribute("statuses",Status.values());

        return "task/status-update";
    }

    @PostMapping("employee/update/{id}")
    public String employeeUpdateTask(@ModelAttribute("task") TaskDTO task){

        taskService.updateStatus(task);
        return "redirect:/task/employee/pending-tasks";
    }

}
