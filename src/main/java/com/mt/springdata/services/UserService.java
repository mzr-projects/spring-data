package com.mt.springdata.services;

import com.mt.springdata.dtos.ProjectUserDto;
import com.mt.springdata.entities.*;
import com.mt.springdata.repositories.CourseRepository;
import com.mt.springdata.repositories.InstructorRepository;
import com.mt.springdata.repositories.UserRepository;
import com.mt.springdata.repositories.UserRepositoryPageAndSort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    private final UserRepositoryPageAndSort userRepositoryPageAndSort;

    public List<ProjectUserDto> getUsers() {
        List<ProjectUserDto> projectUserDtoArrayList = new ArrayList<>();
        List<ProjectUser> projectUsers = userRepository.getAllUsers();
        for (ProjectUser projectUser : projectUsers) {
            ProjectUserDto projectUserDto = new ProjectUserDto(projectUser.getName(),
                    projectUser.getIp().address(),
                    projectUser.getUserType().name(),
                    projectUser.getUserStatus().name());
            projectUserDtoArrayList.add(projectUserDto);
        }
        return projectUserDtoArrayList;
    }

    public List<ProjectUserDto> getByIp(String ip) {
        List<ProjectUserDto> projectUserDtoArrayList = new ArrayList<>();
        List<ProjectUser> projectUsers = userRepository.getProjectUser(ip);
        if (projectUsers != null) {
            for (ProjectUser projectUser : projectUsers) {
                ProjectUserDto projectUserDto = new ProjectUserDto(projectUser.getName(),
                        projectUser.getIp().address(),
                        projectUser.getUserType().name(),
                        projectUser.getUserStatus().name());
                projectUserDtoArrayList.add(projectUserDto);
            }
            return projectUserDtoArrayList;
        } else {
            throw new IllegalArgumentException("Illegal input");
        }
    }

    public void someBusiness() {
        List<ProjectUser> projectUsers = (List<ProjectUser>) userRepository.findAll();
        projectUsers.add(new ProjectUser("James", 7, UserType.EMPLOYEE, UserStatus.ACTIVE,
                new IPv4("127.0.0.1/24")));
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

    public void getSortUsersAndAge() {
        List<ProjectUser> projectUsers = userRepositoryPageAndSort.findAllByName("name",
                Pageable.ofSize(10));
        projectUsers.forEach((data) -> System.out.println("name : " + data.getName()));

        Page<ProjectUser> projectUserPage = userRepositoryPageAndSort.findAllByAgeGreaterThan(10,
                Pageable.ofSize(10));
        projectUserPage.forEach((data) -> System.out.println("age : " + data.getAge()));
    }
}
