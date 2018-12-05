package com.mkadiri.model;

import com.mkadiri.exception.InvalidDirectionException;
import com.mkadiri.model.Coordinates;
import com.mkadiri.model.Hoover;
import com.mkadiri.model.Room;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class HooverTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    Room room;

    @Before
    public void setUp()
    {
        this.room = Mockito.mock(Room.class);
        when(room.getCornerX()).thenReturn(4);
        when(room.getCornerY()).thenReturn(4);
    }

    @Test
    public void test_InvalidDirection() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(4);
        coordinates.setY(4);

        Hoover hoover = new Hoover(coordinates);

        thrown.expect(InvalidDirectionException.class);
        hoover.move('X', this.room);
    }

    @Test
    public void test_ValidNorth() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(1);
        coordinates.setY(1);

        Hoover hoover = new Hoover(coordinates);
        hoover.move('N', this.room);

        assertEquals(2, hoover.getCoordinates().getY());
    }

    @Test
    public void test_ValidOutOfBoundsNorth() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(4);
        coordinates.setY(4);

        Hoover hoover = new Hoover(coordinates);
        hoover.move('N', this.room);

        assertEquals(4, hoover.getCoordinates().getY());
    }

    @Test
    public void test_ValidEast() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(1);
        coordinates.setY(1);

        Hoover hoover = new Hoover(coordinates);
        hoover.move('E', this.room);

        assertEquals(2, hoover.getCoordinates().getX());
    }

    @Test
    public void test_ValidOutOfBoundsEast() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(4);
        coordinates.setY(4);

        Hoover hoover = new Hoover(coordinates);
        hoover.move('E', this.room);

        assertEquals(4, hoover.getCoordinates().getX());
    }


    @Test
    public void test_ValidSouth() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(2);
        coordinates.setY(2);

        Hoover hoover = new Hoover(coordinates);
        hoover.move('S', this.room);

        assertEquals(1, hoover.getCoordinates().getY());
    }

    @Test
    public void test_ValidOutOfBoundsSouth() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(0);
        coordinates.setY(0);

        Hoover hoover = new Hoover(coordinates);
        hoover.move('S', this.room);

        assertEquals(0, hoover.getCoordinates().getY());
    }


    @Test
    public void test_ValidWest() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(2);
        coordinates.setY(2);

        Hoover hoover = new Hoover(coordinates);
        hoover.move('W', this.room);

        assertEquals(1, hoover.getCoordinates().getX());
    }

    @Test
    public void test_ValidOutOfBoundsWest() throws InvalidDirectionException {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(0);
        coordinates.setY(0);

        Hoover hoover = new Hoover(coordinates);
        hoover.move('W', this.room);

        assertEquals(0, hoover.getCoordinates().getX());
    }
}
