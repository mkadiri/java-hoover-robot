package com.mkadiri.model;

import javax.persistence.*;

@Embeddable
public class HooverDetailsOutput {
    @AttributeOverrides({
       @AttributeOverride(name="x", column=@Column(name="end_x")),
       @AttributeOverride(name="y", column=@Column(name="end_y"))
    })
    @Embedded
    private Coordinates coordinates;

    private int patches;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getPatches() {
        return patches;
    }

    public void setPatches(int patches) {
        this.patches = patches;
    }
}
