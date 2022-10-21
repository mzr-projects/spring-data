package com.mt.springdata.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class InstructorDetailDto {

    private String name;
    private String university;
    private String city;
}
