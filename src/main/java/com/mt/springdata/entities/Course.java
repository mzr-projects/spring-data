package com.mt.springdata.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "Course_Instructor",
			joinColumns = {@JoinColumn(name = "course_id")},
			inverseJoinColumns = {@JoinColumn(name = "instructor_id")}
	)
	private Set<Instructor> instructors;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}
}
