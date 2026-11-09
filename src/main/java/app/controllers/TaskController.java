package app.controllers;

import app.dto.TaskDto;
import app.entity.Task;
import app.entity.TaskStatus;
import app.repository.TaskRepository;
import app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping
    private void create(@RequestBody TaskDto task){
        service.addTask(task);
    }

    @PutMapping("/{id}/completed")
    private void completedTask(@PathVariable Long id, @RequestParam String status){
        service.updateTaskStatus(id,status);
    }

    @GetMapping
    private List<TaskDto> getAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    private TaskDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    private TaskDto update(@PathVariable Long id, @RequestBody TaskDto taskDto){
        return service.update(id, taskDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id){
        service.delete(id);
    }
}
