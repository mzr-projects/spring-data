package com.mt.springdata.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Topic")
@Table(name = "topic")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "topic_type_id",
        columnDefinition = "VARCHAR(3)"
)
@DiscriminatorValue("TPC")
@Getter
@Setter
public class Topic {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String owner;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();
}
