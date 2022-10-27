package com.mt.springdata.services;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.mt.springdata.dtos.InstructorDetailDto;
import com.mt.springdata.entities.Instructor;
import com.mt.springdata.entities.InstructorDetails;
import com.mt.springdata.repositories.InstructorDetailsRepository;
import com.mt.springdata.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InstructorService implements IInstructorDetails {

    private final InstructorDetailsRepository instructorDetailsRepository;
    private final InstructorRepository instructorRepository;
    private final CriteriaBuilderFactory criteriaBuilderFactory;

    @PersistenceContext
    private final EntityManager entityManager;

    public void addInstructorDetails(InstructorDetailDto instructorDetailDto) {
        Instructor instructor = instructorRepository.findByName(instructorDetailDto.getName());
        if (instructor != null) {
            InstructorDetails instructorDetails = new InstructorDetails();
            instructorDetails.setInstructor(instructor);
            instructorDetails.setCity(instructorDetailDto.getCity());
            instructorDetails.setUniversity(instructorDetailDto.getUniversity());
            instructorDetailsRepository.save(instructorDetails);
        } else {
            log.error("Instructor doesn't exist");
        }
    }

    public void addInstructorDetailsBlazePersistence(InstructorDetailDto instructorDetailDto) {
        CriteriaBuilder<Instructor> criteriaBuilder = criteriaBuilderFactory.create(entityManager, Instructor.class)
                .from(Instructor.class)
                .select("instructor.name");
        if (criteriaBuilder.getResultList() != null) {
            InstructorDetails instructorDetails = new InstructorDetails();
            instructorDetails.setInstructor(criteriaBuilder.getSingleResult());
            instructorDetails.setCity(instructorDetailDto.getCity());
            instructorDetails.setUniversity(instructorDetailDto.getUniversity());
            instructorDetailsRepository.save(instructorDetails);
        } else {
            log.error("Instructor doesn't exist");
        }
    }

}
