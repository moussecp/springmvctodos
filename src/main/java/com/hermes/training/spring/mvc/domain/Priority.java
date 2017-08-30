package com.hermes.training.spring.mvc.domain;

public enum Priority {
    VERY_HIGH(5),
    HIGH(4),
    MEDIUM(3),
    LOW(2),
    VERY_LOW(1);

    private int priorityLevel;

    Priority(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public static Priority getDefault() {
        return Priority.MEDIUM;
    }
}
