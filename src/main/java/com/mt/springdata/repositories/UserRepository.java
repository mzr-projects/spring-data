package com.mt.springdata.repositories;

import com.mt.springdata.entities.ProjectUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ProjectUser, Long> {

}
