package com.mt.springdata.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@DiscriminatorValue("CRS")
public class Course extends Topic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /*
     * Cascade REMOVE will affect both intermediary table and the other end as well
     * Cause in many to many both ends are independent cascading only makes sense from
     * parent side to the child and that's done automatically by hibernate thats why
     * orphanRemoval and Cascade.REMOVE are not desirable in many-to-many associations
     * */
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
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

    /*
     * In Bidirectional associations this method is a very good practice to sync both sides
     * */
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
        instructor.getCourses().add(this);
    }

    /*
     * In Bidirectional associations this method is a very good practice to sync both sides
     * */
    public void removeInstructor(Instructor instructor) {
        instructors.remove(instructor);
        instructor.getCourses().remove(this);
    }
}
