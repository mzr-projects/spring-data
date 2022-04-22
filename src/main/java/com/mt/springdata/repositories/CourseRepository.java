package com.mt.springdata.repositories;

import com.mt.springdata.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Long> {

}
