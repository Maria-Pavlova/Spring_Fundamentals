package com.example.gira.services;

import com.example.gira.models.dtos.bindingModels.AddTaskModel;
import com.example.gira.models.dtos.viewModels.TasksViewModel;
import com.example.gira.models.entities.Task;
import com.example.gira.models.enums.Progress;
import com.example.gira.repositories.TaskRepository;
import com.example.gira.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ClassificationService classificationService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper,
                       ClassificationService classificationService, UserService userService,
                       CurrentUser currentUser) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.classificationService = classificationService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    public void addTask(AddTaskModel taskModel) {
        Task task = modelMapper.map(taskModel, Task.class);
        task.setClassification(classificationService.findByName(taskModel.getClassification()));
        task.setUser(userService.findByUsername(currentUser.getUsername()).get());
        task.setProgress(Progress.OPEN);
        taskRepository.saveAndFlush(task);
    }

    public List<TasksViewModel> findAll() {
       return taskRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TasksViewModel.class))
                .toList();
    }

    public void changeTaskProgress(Long id) {
        Task task = taskRepository.findById(id).get();
        Progress progress = task.getProgress();
        switch (progress){
            case OPEN -> task.setProgress(Progress.IN_PROGRESS);
            case IN_PROGRESS -> task.setProgress(Progress.COMPLETED);
        }
        if (progress.equals(Progress.COMPLETED)){
            taskRepository.delete(task);
        }else
        taskRepository.save(task);
    }
}
