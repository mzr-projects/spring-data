package com.mt.springdata.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "PROJECT_USER")
@Table(name = "PROJECT_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int age;

}
