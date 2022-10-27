package com.mt.springdata.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class InstructorDetailDto implements Serializable {

    private String name;
    private String university;
    private String city;
}
