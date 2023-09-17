package com.projoboard.projo.project;

import com.projoboard.projo.models.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Project extends BaseEntity {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}