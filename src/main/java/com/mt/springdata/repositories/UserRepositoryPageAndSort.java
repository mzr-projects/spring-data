package com.mt.springdata.repositories;

import com.mt.springdata.entities.ProjectUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepositoryPageAndSort extends PagingAndSortingRepository<ProjectUser, Long> {

    List<ProjectUser> findAllByName(String name, Pageable pageable);

    Page<ProjectUser> findAllByAgeGreaterThan(int age, Pageable pageable);

}
