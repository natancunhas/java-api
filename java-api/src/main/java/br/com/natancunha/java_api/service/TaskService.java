package br.com.natancunha.java_api.service;

import br.com.natancunha.java_api.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Task create(Task task) {
        Long id = nextId.getAndIncrement();

        Task newTask = new Task(
            id,
            task.getTitle(),
            task.getDescription(),
            task.isCompleted()
        );

        tasks.put(id, newTask);
        return newTask;
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Task findById(Long id) {
        return tasks.get(id);
    }
}
