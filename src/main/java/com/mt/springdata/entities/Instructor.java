package com.mt.springdata.entities;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@Entity
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private String name;

    /*
     * Bidirectional many-to-many
     * */
    @ManyToMany(mappedBy = "instructors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Course> courses;

    /*
     * mappedBy defines the child property which owns the relationship
     * */
    /*
    @OneToOne(mappedBy = "instructor", orphanRemoval = true, cascade = CascadeType.ALL)
    private InstructorDetails instructorDetails;
    */

    public Instructor(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    /*
     * Here we define utility method to sync both sides of the relationship
     * */
    /*public void setInstructorDetails(InstructorDetails instructorDetails) {
        this.instructorDetails = instructorDetails;
        instructorDetails.setInstructor(this);
    }*/
}
