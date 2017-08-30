package com.hermes.training.spring.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @SequenceGenerator(name = "CATEGORY_SEQ")
    private Long id;

    @NotNull
    @Column(name = "CREATION_DATE")
    private final LocalDateTime creationDate = LocalDateTime.now();

    @Size(min = 3, message = "Enter at least 3 characters")
    private String name;

    public Category(Long id, String name) {
        this(name);
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(creationDate, category.creationDate) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, name);
    }
}
