package com.mt.springdata.entities;

import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "PROJECT_USER")
@Table(name = "project_user")
@Getter
@Setter
@NoArgsConstructor
@TypeDef(name = "ipv4", typeClass = IPv4Type.class, defaultForType = IPv4.class)
public class ProjectUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @Column(name = "ip", columnDefinition = "inet")
    private IPv4 ip;

    /*
     * Length of this enum_type will be 8 bytes (VARCHAR(8))
     * */
    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private UserType userType;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "int2")
    private UserStatus userStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userStatus", insertable = false, updatable = false)
    private UserStatusInfo userStatusInfo;

    public ProjectUser(String name, int age, UserType userType, UserStatus userStatus, IPv4 iPv4) {
        this.name = name;
        this.age = age;
        this.userType = userType;
        this.userStatus = userStatus;
        this.ip = iPv4;
    }

    public void setIp(String address) {
        this.ip = new IPv4(address);
    }
}
