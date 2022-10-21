package com.mt.springdata.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "PROJECT_USER_POST")
@Table(name = "project_user_post")
@Getter
@Setter
@NoArgsConstructor
public class ProjectUserPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post")
    private String post;

    @Column(name = "post_date")
    private Date date;

    @ManyToOne
    private ProjectUser projectUserSet;

    public ProjectUserPost(String post, Date date) {
        this.post = post;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectUserPost that = (ProjectUserPost) o;
        return com.google.common.base.Objects.equal(id, that.id) &&
                com.google.common.base.Objects.equal(post, that.post) &&
                com.google.common.base.Objects.equal(date, that.date);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(id, post, date);
    }
}
