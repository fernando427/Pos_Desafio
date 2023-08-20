package com.compass.scholarshipprogram.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "description")
public class Description {
    @Id
    @Column(name = "description_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "description")
    private List<Classes> classes;

    public Description() {
    }

    public Description(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ClassesDescription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
