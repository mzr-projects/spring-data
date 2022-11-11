package com.mt.springdata.controllers;

import com.mt.springdata.dtos.ProjectUserByIp;
import com.mt.springdata.dtos.ProjectUserDto;
import com.mt.springdata.entities.ProjectUser;
import com.mt.springdata.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/all")
    public List<ProjectUserDto> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/project-user-by-ip")
    public List<ProjectUserDto> getAllUsers(@RequestBody ProjectUserByIp projectUserByIp) {
        return userService.getByIp(projectUserByIp.getIp());
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

    @GetMapping(value = "/get-sort-date")
    public void sortService() {
        userService.getSortUsersAndAge();
    }
}
