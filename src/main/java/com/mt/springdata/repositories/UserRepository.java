package com.mt.springdata.repositories;

import com.mt.springdata.entities.ProjectUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<ProjectUser, Long> {

    @Query(value = "select pu from PROJECT_USER pu")
    List<ProjectUser> getAllUsers();

    @Query(value = "select * from PROJECT_USER pu where pu.ip && CAST(:network AS inet) = true", nativeQuery = true)
    List<ProjectUser> getProjectUser(@Param("network") String network);
}
