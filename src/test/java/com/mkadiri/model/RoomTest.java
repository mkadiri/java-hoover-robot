package com.mkadiri.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    @Test
    public void test_GetCornerX() {
        Room room = new Room(4, 4);

        assertEquals(3, room.getCornerX());
    }

    @Test
    public void test_OutOfBoundsGetCornerX() {
        Room room = new Room(0, 0);

        assertEquals(0, room.getCornerX());
    }

    @Test
    public void test_GetCornerY() {
        Room room = new Room(4, 4);

        assertEquals(3, room.getCornerY());
    }

    @Test
    public void test_OutOfBoundsGetCornerY() {
        Room room = new Room(0, 0);

        assertEquals(0, room.getCornerY());
    }
}
