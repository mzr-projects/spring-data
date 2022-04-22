package com.mt.springdata.controllers;

import com.mt.springdata.entities.ProjectUser;
import com.mt.springdata.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping(value = "/all")
	public List<ProjectUser> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping(value = "/business")
	public void getAfterBusiness() {
		userService.someBusiness();
	}

	@GetMapping(value = "/get-instructors")
	public void getInstructors(@RequestParam(value = "course_id") Long courseId) {
		userService.getInstructors(courseId);
	}

	@GetMapping(value = "/get-courses")
	public void getCourses(@RequestParam(value = "instructor_id") Long instructorId) {
		userService.getCourses(instructorId);
	}
}
