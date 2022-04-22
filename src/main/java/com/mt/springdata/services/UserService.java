package com.mt.springdata.services;

import com.mt.springdata.entities.Course;
import com.mt.springdata.entities.Instructor;
import com.mt.springdata.entities.ProjectUser;
import com.mt.springdata.repositories.CourseRepository;
import com.mt.springdata.repositories.InstructorRepository;
import com.mt.springdata.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	private final InstructorRepository instructorRepository;

	public List<ProjectUser> getUsers() {
		return (List<ProjectUser>) userRepository.findAll();
	}

	public void someBusiness() {
		List<ProjectUser> projectUsers = (List<ProjectUser>) userRepository.findAll();
		projectUsers.add(new ProjectUser(6L, "James", 7));
		userRepository.deleteById(1L);
	}

	public void getInstructors(Long courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		if (course.isPresent()) {
			Set<Instructor> instructorSet = course.get().getInstructors();
			instructorSet.forEach((instructor -> {
				log.info("Instructor name : {}", instructor.getName());
			}));
		}
	}

	public void getCourses(Long instructorId) {
		Optional<Instructor> instructor = instructorRepository.findById(instructorId);
		if (instructor.isPresent()) {
			Set<Course> instructorSet = instructor.get().getCourses();
			instructorSet.forEach((course -> {
				log.info("Course name : {}", course.getName());
			}));
		}
	}

}
