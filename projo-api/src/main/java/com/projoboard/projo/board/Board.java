package com.projoboard.projo.board;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projoboard.projo.models.BaseEntity;
import com.projoboard.projo.task.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "boards")
public class Board extends BaseEntity {

    private String title;

    @OneToMany(mappedBy = "board", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Task> tasks = new HashSet<>();

    public Board(String title, Set<Task> tasks) {
        this.title = title;
        this.tasks = tasks;
    }

    public Board() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks.clear();
        this.tasks.addAll(tasks);
        tasks.forEach(task -> task.setBoard(this));
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        task.setBoard(this);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
        task.setBoard(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(title, board.title) && Objects.equals(tasks, board.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, tasks);
    }

    @Override
    public String toString() {
        return "Board{" +
                "title='" + title + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}