package com.example.gira.web.controllers;

import com.example.gira.models.dtos.bindingModels.AddTaskModel;
import com.example.gira.security.CurrentUser;
import com.example.gira.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final CurrentUser currentUser;

    public TaskController(TaskService taskService, CurrentUser currentUser) {
        this.taskService = taskService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("taskModel")
    public AddTaskModel taskModel(){
        return new AddTaskModel();
    }

    @GetMapping("/add")
    public String getAddForm(){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String addTask(@Valid AddTaskModel taskModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskModel", taskModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskModel", bindingResult);
            return "redirect:/tasks/add";
        }
        taskService.addTask(taskModel);
        return "redirect:/home";
    }

    @GetMapping("/progress/{id}")
    public String changeProgress(@PathVariable Long id){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        taskService.changeTaskProgress(id);
        return "redirect:/home";
    }
}
