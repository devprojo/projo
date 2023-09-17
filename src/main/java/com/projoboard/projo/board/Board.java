package com.projoboard.projo.board;

import com.projoboard.projo.models.BaseEntity;

public class Board extends BaseEntity {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}