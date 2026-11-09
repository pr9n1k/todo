package app.service;

import app.dto.TaskDto;
import app.entity.Task;
import app.entity.TaskStatus;
import app.mapper.TaskMapper;
import app.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    private final TaskMapper taskMapper;

    @Transactional
    public TaskDto addTask(TaskDto dto){
        Task task = taskMapper.toEntity(dto);
        task.setStatus(TaskStatus.ACTIVE);
        Task saved = repository.create(task);
        return taskMapper.toDto(saved);
    }

    @Transactional
    public TaskDto getById(Long id){
        Task task = repository.findById(id);
        TaskDto result = task != null ? taskMapper.toDto(task) : null;
        return result;
    }

    @Transactional(readOnly = true)
    public List<TaskDto> getAll(){
        List<Task> tasks = repository.findAll();
        return tasks.stream().map(taskMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public TaskDto update(Long id, TaskDto taskDto){
        Task task = repository.findById(id);
        if(task == null){
            throw new RuntimeException("Task not found");
        }
        Task taskEntity = taskMapper.toEntity(taskDto);
        taskEntity.setUpdate(LocalDateTime.now());
        Task updated = repository.update(taskEntity);
        return taskMapper.toDto(updated);
    }

    @Transactional
    public void delete(Long id){
        Task task = repository.findById(id);
        if(task == null){
            throw new RuntimeException("Task not found");
        }
        repository.delete(id);
    }

    @Transactional
    public TaskDto updateTaskStatus(Long id, String status){
        Task task = repository.findById(id);
        if(task == null){
            throw new RuntimeException("Task not found");
        }
        TaskStatus taskStatus = TaskStatus.customValueOf(status);
        task.setStatus(taskStatus);
        Task updated = repository.update(task);
        return taskMapper.toDto(updated);
    }
}
