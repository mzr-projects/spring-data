package com.mt.springdata.repositories;

import com.mt.springdata.entities.InstructorDetails;
import org.springframework.data.repository.CrudRepository;

public interface InstructorDetailsRepository extends CrudRepository<InstructorDetails,Long> {
}
