package com.infoshare.demojjdd5.controller;

import com.infoshare.demojjdd5.model.Status;
import com.infoshare.demojjdd5.model.Task;
import com.infoshare.demojjdd5.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
    public Task postTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Status status) {
        return taskRepository.findAllByStatus(status);
    }

    @PutMapping("/staus/{id}/{status}")
    public void updateStatus(@PathVariable Long id, @PathVariable Status status) {
        Optional<Task> taskOpt = taskRepository.findById(id);
        Task task = taskOpt.get();
        task.setStatus(status);
        taskRepository.save(task);
    }


}
