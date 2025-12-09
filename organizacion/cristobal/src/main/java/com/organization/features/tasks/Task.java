package com.organization.features.tasks;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;
}
