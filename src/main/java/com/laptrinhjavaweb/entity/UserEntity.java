package com.laptrinhjavaweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class UserEntity extends BaseEntity {
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String fullname;

    @Column
    private Integer status;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles = new ArrayList<>();
}
