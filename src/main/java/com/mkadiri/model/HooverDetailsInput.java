package com.mkadiri.model;

import javax.persistence.*;
import java.util.List;

@Embeddable
public class HooverDetailsInput {
    @AttributeOverrides({
        @AttributeOverride(name="x", column=@Column(name="room_size_x")),
        @AttributeOverride(name="y", column=@Column(name="room_size_y"))
    })
    @Embedded
    private Coordinates roomSize;

    @AttributeOverrides({
        @AttributeOverride(name="x", column=@Column(name="start_x")),
        @AttributeOverride(name="y", column=@Column(name="start_y"))
    })
    @Embedded
    private Coordinates coordinates;

    @ElementCollection
    private List<Coordinates> patches;

    private String instructions;

    public Coordinates getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Coordinates roomSize) {
        this.roomSize = roomSize;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinates> getPatches() {
        return patches;
    }

    public void setPatches(List<Coordinates> patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}