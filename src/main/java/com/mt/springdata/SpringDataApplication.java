package com.mt.springdata;

import com.mt.springdata.entities.Course;
import com.mt.springdata.entities.Instructor;
import com.mt.springdata.repositories.CourseRepository;
import com.mt.springdata.repositories.InstructorRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableBatchProcessing
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private InstructorRepository instructorRepository;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Instructor instructor1 = new Instructor();
		instructor1.setName("Jimmy");
		Instructor instructor2 = new Instructor();
		instructor2.setName("James");
		Instructor instructor3 = new Instructor();
		instructor3.setName("John");
		Instructor instructor4 = new Instructor();
		instructor4.setName("Wick");
		Instructor instructor5 = new Instructor();
		instructor5.setName("Jose");
		Instructor instructor6 = new Instructor();
		instructor6.setName("Mose");
		Instructor instructor7 = new Instructor();
		instructor7.setName("DOSE");
		Instructor instructor8 = new Instructor();
		instructor8.setName("KOSE");

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
