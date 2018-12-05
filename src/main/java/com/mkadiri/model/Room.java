package com.mkadiri.model;

public class Room {
    private int width;
    private int height;

    public Room(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getCornerX() {
        int x = this.width - 1;
        return x > 0 ? x : 0;
    }

    public int getCornerY() {
        int y = this.height - 1;
        return y > 0 ? y : 0;
    }
}