package com.example.survey.repository;

import com.example.survey.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> {

    @Query(value = "select * from projects p join users u on p.id = u.project_id where u.username=:username", nativeQuery = true)
    List<Project> findProjectsByUsername(@Param(value = "username") String username);
}
