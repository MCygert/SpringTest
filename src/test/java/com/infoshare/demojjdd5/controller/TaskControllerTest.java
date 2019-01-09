package com.infoshare.demojjdd5.controller;

import com.infoshare.demojjdd5.model.Task;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerTest {
    @Autowired
    TaskController taskController;

    @Test
    public void getAllTasksShouldReturn2Tasks() {
        // given
        List<Task> tasks = taskController.getAllTasks();
        // when
        // then
        Assertions.assertThat(tasks).hasSize(2);
    }

    @Test
    public void getTaskByIDWithBadId() {
        // given
        long testID = 150;
        ResponseEntity<Task> testObj = taskController.getTaskById(testID);
        // then
        Assertions.assertThat(testObj).isEqualTo(ResponseEntity.notFound().build());
    }

    @Test
    public void getTaskWithId() {
        //given
        long testId = 1;
        ResponseEntity<Task> testObj = taskController.getTaskById(testId);
        Task task = testObj.getBody();
        //then
        Assertions.assertThat(testObj).isEqualTo(ResponseEntity.ok());
    }

    @Test
    public void deleteTask() {
    }

    @Test
    public void getTasksByStatus() {
    }

    @Test
    public void updateStatus() {
    }
}