package com.mt.springdata.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "UserStatusInfo")
@Table(name = "user_status_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "UserStatusInfo")
public class UserStatusInfo implements Serializable {

    @Id
    @Column(columnDefinition = "int2")
    private Long id;

    private String description;

    private String name;
}
