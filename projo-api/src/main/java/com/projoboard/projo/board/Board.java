package com.projoboard.projo.board;

import com.projoboard.projo.models.BaseEntity;
import com.projoboard.projo.task.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "boards")
public class Board extends BaseEntity {

    private String title;

    @OneToMany
    @JoinColumn(name = "board_id")
    @Cascade(CascadeType.DELETE_ORPHAN)
    private Set<Task> tasks;

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
        this.tasks = tasks;
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