package com.example.survey.repository;

import com.example.survey.model.Project;
import com.example.survey.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findAllByProjectId(Long projectId);


    @Query(value = "select * from tasks t join projects p on p.id = t.project_id join users u on u.project_id = p.id where u.username=:username", nativeQuery = true)
    List<Task> findAllByUsername(@Param(value = "username") String username);
}
