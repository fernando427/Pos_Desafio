package com.compass.scholarshipprogram.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "description_id")
    private Description description;

    @OneToMany(mappedBy = "classes")
    private List<User> user;

    public Classes() {
    }

    public Classes(Long id, String name, Description description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public Description getDescriptionId() {
        return description;
    }

    public void setDescriptionId(Description description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description=" + description +
                '}';
    }
}
