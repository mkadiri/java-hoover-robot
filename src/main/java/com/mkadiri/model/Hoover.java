package com.mkadiri.model;

import com.mkadiri.exception.InvalidDirectionException;

public class Hoover {
    private Coordinates coordinates;

    public Hoover(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void move(char direction, Room room) throws InvalidDirectionException {
        if (direction == 'N') {
            int y = this.coordinates.getY() + 1;

            if (y <= room.getCornerY()) {
                coordinates.setY(y);
            }

            return;
        }

        if (direction == 'E') {
            int x = this.coordinates.getX() + 1;

            if (x <= room.getCornerX()) {
                coordinates.setX(x);
            }

            return;
        }

        if (direction == 'S') {
            int y = this.coordinates.getY() - 1;

            if (y > 0) {
                this.coordinates.setY(y);
            }

            return;
        }

        if (direction == 'W') {
            int x = this.coordinates.getX() - 1;

            if (x > 0) {
                this.coordinates.setX(x);
            }

            return;
        }

        throw new InvalidDirectionException();
    }
}