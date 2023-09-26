package com.projoboard.projo.project;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projoboard.projo.board.Board;
import com.projoboard.projo.models.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity {
    public String title;

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Board> boards = new HashSet<>();

    public Project(String title, Set<Board> boards) {
        this.title = title;
        this.boards = boards;
    }

    public Project() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Board> getBoards() {
        return boards;
    }

    public void setBoards(Set<Board> boards) {
        this.boards = boards;
    }

    public void addBoard(Board board) {
        this.boards.add(board);
        board.setProject(this);
    }

    public void removeBoard(Board board) {
        this.boards.remove(board);
        board.setProject(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(title, project.title) && Objects.equals(boards, project.boards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, boards);
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", boards=" + boards +
                '}';
    }
}