package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class ControllerClass {
    @Autowired
    ServiceClass service;
    @GetMapping("/alltasks")
    public List<ModelTask> getAllTasks()
    {
        return service.findAllTask();
    }
    @PostMapping("/saveTask")
    public ModelTask addTask(@RequestBody ModelTask mt)
    {
        return service.addTask(mt);
    }
    @GetMapping("/deleteTask")
    public void deleteTask(@RequestParam String taskId)
    {
        
    service.deleteTask(Integer.valueOf(taskId));
    }
    @GetMapping("/getTask")
    public Optional<ModelTask> getbyId(@RequestParam String taskId)
    {
        return service.getTaskById(Integer.valueOf(taskId));
    }


    
}
