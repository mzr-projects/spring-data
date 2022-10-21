package com.mt.springdata.repositories;

import com.mt.springdata.entities.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {

    Instructor findByName(String name);
}
