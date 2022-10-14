package com.mt.springdata.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUserDto {

    private String name;
    private String ip;
    private String userType;
    private String userStatus;
}
