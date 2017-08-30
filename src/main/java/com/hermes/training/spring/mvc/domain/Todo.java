package com.hermes.training.spring.mvc.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Todo {
    @Id
    @SequenceGenerator(name = "TODO_SEQ")
    private Long id;

    @NotNull
    private final User user;

    @NotNull
    @Column(name = "CREATION_DATE")
    private final LocalDateTime creationDate = LocalDateTime.now();

    @NotNull
    @Column(name = "TARGET_DATE")
    private LocalDateTime targetDate = LocalDateTime.now().plusDays(7L);

    private Boolean isDone = false;

    @Size(min = 6, message = "Enter at least 6 characters")
    private String desc;

    private Priority priority = Priority.getDefault();

    private Category category;


    public Todo(User user, String desc, LocalDateTime targetDate, Category category, Priority priority) {
        this(user, desc, category, priority);
        this.targetDate = targetDate;
    }

    public Todo(User user, String desc, Category category, Priority priority) {
        this(user, desc, category);
        this.priority = priority;
    }

    public Todo(User user, String desc, Category category) {
        this(user, desc);
        this.category = category;
    }

    public Todo(User user, String desc) {
        this.user = user;
        this.desc = desc;
    }

    public Todo(Long id, User user, String desc, LocalDateTime targetDate, Category category, Priority priority) {
        this(id, user, desc, category, priority);
        this.targetDate = targetDate;
    }

    public Todo(Long id, User user, String desc, Category category, Priority priority) {
        this(id, user, desc, category);
        this.priority = priority;
    }

    public Todo(Long id, User user, String desc, Category category) {
        this(id, user, desc);
        this.category = category;
    }

    public Todo(Long id, User user, String desc) {
        this(user, desc);
        this.id = id;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Boolean getDone() {
        return isDone;
    }

    public String getDesc() {
        return desc;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getTargetDate() {
        return targetDate;
    }

    public String getFormattedDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public Priority getPriority() {
        return priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
