package io.ifnmg.oop.repository;

import jakarta.persistence.*;

@MappedSuperclass
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean inTrash = false;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getInTrash() {
        return inTrash;
    }
    public void setInTrash(Boolean value) {
        this.inTrash = value;
    }
}
