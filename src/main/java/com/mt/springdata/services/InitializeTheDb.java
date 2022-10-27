package com.mt.springdata.services;

import com.mt.springdata.entities.*;
import com.mt.springdata.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Transactional
@RequiredArgsConstructor
public class InitializeTheDb {

    private final CourseRepository courseRepository;

    private final InstructorRepository instructorRepository;

    private final UserStatusInfoRepository userStatusInfoRepository;

    private final UserRepository userRepository;

    private final InstructorDetailsRepository instructorDetailsRepository;

    public void init() {
        UserStatusInfo userStatusInfo = new UserStatusInfo(1L, "User is suspended from any activity", "SUSPEND");
        UserStatusInfo userStatusInfo1 = new UserStatusInfo(2L, "User is active.", "ACTIVE");
        UserStatusInfo userStatusInfo2 = new UserStatusInfo(3L, "User is inactive", "INACTIVE");
        UserStatusInfo userStatusInfo3 = new UserStatusInfo(4L, "User is disabled", "DISABLED");
        userStatusInfoRepository.save(userStatusInfo);
        userStatusInfoRepository.save(userStatusInfo1);
        userStatusInfoRepository.save(userStatusInfo2);
        userStatusInfoRepository.save(userStatusInfo3);

        ProjectUser projectUser1 = new ProjectUser("James", 31, UserType.EMPLOYEE, UserStatus.ACTIVE,
                new IPv4("192.168.1.1/24"));
        ProjectUser projectUser2 = new ProjectUser("Jimmy", 47, UserType.MANAGER, UserStatus.INACTIVE,
                new IPv4("192.168.126.1/24"));
        ProjectUser projectUser3 = new ProjectUser("Jordan", 17, UserType.ADMIN, UserStatus.ACTIVE,
                new IPv4("192.168.176.1/24"));
        ProjectUser projectUser4 = new ProjectUser("Michael", 27, UserType.EMPLOYEE, UserStatus.DISABLED,
                new IPv4("192.168.1.100/24"));
        projectUser1.addPost(new ProjectUserPost("This is a good one", new Date()));
        projectUser2.addPost(new ProjectUserPost("This is a Bad one", new Date()));
        projectUser3.addPost(new ProjectUserPost("This is a Ugly  one", new Date()));
        projectUser4.addPost(new ProjectUserPost("This is a MF one", new Date()));
        userRepository.save(projectUser1);
        userRepository.save(projectUser2);
        userRepository.save(projectUser3);
        userRepository.save(projectUser4);

        Instructor instructor1 = new Instructor("Jimmy");
        Instructor instructor2 = new Instructor("James");
        Instructor instructor3 = new Instructor("John");
        Instructor instructor4 = new Instructor("Wick");
        Instructor instructor5 = new Instructor("Jose");
        Instructor instructor6 = new Instructor("Mose");
        Instructor instructor7 = new Instructor("DOSE");
        Instructor instructor8 = new Instructor("ROSE");

        Set<Instructor> instructorSet1 = new HashSet<>();
        instructorSet1.add(instructor1);
        instructorSet1.add(instructor2);
        instructorSet1.add(instructor6);
        instructorSet1.add(instructor7);
        instructorSet1.add(instructor8);

        Set<Instructor> instructorSet2 = new HashSet<>();
        instructorSet2.add(instructor3);

        Set<Instructor> instructorSet3 = new HashSet<>();
        instructorSet3.add(instructor4);
        instructorSet3.add(instructor5);

        Course course1 = new Course();
        course1.setName("Java Core");
        Course course2 = new Course();
        course2.setName("Spring Boot");
        Course course3 = new Course();
        course3.setName("AWS");

        course1.setInstructors(instructorSet1);
        course2.setInstructors(instructorSet2);
        course3.setInstructors(instructorSet3);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
    }
}
