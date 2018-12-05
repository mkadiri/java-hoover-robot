package com.mkadiri.model;

import java.util.ArrayList;
import java.util.List;

public class PatchCollection {
    private List<Patch> patches = new ArrayList<>();

    public void cleanPatch(Coordinates coordinates) {
        for (Patch patch : this.patches) {
            if (patch.getCoordinates().getX() == coordinates.getX() && patch.getCoordinates().getY() == coordinates.getY()) {
                patch.setCleaned(true);
            }
        }
    }

    public int getNumberCleanedPatches() {
        int count = 0;

        for (Patch patch : this.patches) {
            if (patch.isCleaned()) {
                count++;
            }
        }

        return count;
    }

    public void add(Patch patch) {
        this.patches.add(patch);
    }
}
