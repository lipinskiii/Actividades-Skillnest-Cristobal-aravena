package com.organization.features.tasks;

import com.organization.features.tasks.exception.TaskValidationException;
import java.util.List;

public class TaskService {

    private final TaskRepository repository = new TaskRepository();

    public void addTask(Task task) {
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new TaskValidationException("El título es obligatorio");
        }
        repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }
}
