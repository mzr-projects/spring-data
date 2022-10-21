package com.mt.springdata.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class InstructorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String university;

    /**
     * If we wanted to use @JoinColumn to refer to the instructor_id as the parent id
     * then we had two ids in instructor_details table one as the instructor_details_id (primary_key) and
     * another as the instructor_id (foreign_key) to the parent instead
     * We use MapsId to make InstructorDetails id and Instructor id unified, now these two tables share the same
     * primary_key
     */
    @OneToOne
    @MapsId
    private Instructor instructor;

    public InstructorDetails(String city, String university) {
        this.city = city;
        this.university = university;
    }
}
