package com.organization.features.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicInteger idSequence = new AtomicInteger(1);

    public void save(Task task) {
        if (task.getId() == 0) {
            task.setId(idSequence.getAndIncrement());
            tasks.add(task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId() == task.getId()) {
                    tasks.set(i, task);
                    return;
                }
            }
            tasks.add(task);
        }
    }

    public List<Task> findAll() {
        return Collections.unmodifiableList(tasks);
    }

    public void deleteById(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}
