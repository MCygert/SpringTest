package com.infoshare.demojjdd5.repository;

import com.infoshare.demojjdd5.model.Status;
import com.infoshare.demojjdd5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByStatus(Status status);
}
