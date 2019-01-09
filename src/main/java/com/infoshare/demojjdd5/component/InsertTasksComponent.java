package com.infoshare.demojjdd5.component;

import com.infoshare.demojjdd5.model.Status;
import com.infoshare.demojjdd5.model.Task;
import com.infoshare.demojjdd5.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InsertTasksComponent {
    private final TaskRepository taskRepository;

    @Autowired
    public InsertTasksComponent(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    public void fillData() {
        Task task = new Task((long) 1, "Homework", Status.TODO);
        taskRepository.save(task);
        Task task1 = new Task((long) 2, "Breakfast", Status.FINISHED);
        taskRepository.save(task1);

    }

}
