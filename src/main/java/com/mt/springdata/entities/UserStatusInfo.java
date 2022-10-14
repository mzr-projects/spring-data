package com.mt.springdata.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "UserStatusInfo")
@Table(name = "user_status_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusInfo implements Serializable {

    @Id
    @Column(columnDefinition = "int2")
    private Long id;

    private String description;

    private String name;
}
