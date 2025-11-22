package com.example.userService.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor   // Only generate the no-argument constructor for JPA
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // e.g. ROLE_USER, ROLE_ADMIN

    // Custom constructor required by your service to create new roles
    public Role(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Role)) return false;
        Role r = (Role) o;
        return Objects.equals(id, r.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
