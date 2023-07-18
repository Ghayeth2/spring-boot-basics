package com.patika_course.model.entities;

import com.patika_course.core.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity @Table(name = "roles")
@Log4j2 @Builder @Data @NoArgsConstructor
public class Role extends BaseEntity{
    @Column(nullable = false, length = 10, unique = true)
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
