package com.mkadiri.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PatchCollectionTest {
    private Patch patch1;

    private Patch patch2;

    private Patch patch3;

    private Patch patch4;

    @Before
    public void setUp()
    {
        Coordinates coordinates1 = new Coordinates();
        coordinates1.setX(1);
        coordinates1.setY(0);
        this.patch1 = new Patch(coordinates1);

        Coordinates coordinates2 = new Coordinates();
        coordinates2.setX(2);
        coordinates2.setY(2);
        this.patch2 = new Patch(coordinates2);

        Coordinates coordinates3 = new Coordinates();
        coordinates3.setX(2);
        coordinates3.setY(3);
        this.patch3 = new Patch(coordinates3);

        Coordinates coordinates4 = new Coordinates();
        coordinates4.setX(2);
        coordinates4.setY(4);
        this.patch4 = new Patch(coordinates4);
    }

    @Test
    public void test_cleanOnePatches() {
        PatchCollection patchCollection = new PatchCollection();
        patchCollection.add(patch1);
        patchCollection.add(patch2);
        patchCollection.add(patch3);
        patchCollection.add(patch4);

        Coordinates coordinates = new Coordinates();
        coordinates.setX(1);
        coordinates.setY(0);
        patchCollection.cleanPatch(coordinates);

        assertEquals(1, patchCollection.getNumberCleanedPatches());
    }

    @Test
    public void test_cleanTwoPatches() {
        PatchCollection patchCollection = new PatchCollection();
        patchCollection.add(patch1);
        patchCollection.add(patch2);
        patchCollection.add(patch3);
        patchCollection.add(patch4);

        Coordinates coordinates = new Coordinates();
        coordinates.setX(1);
        coordinates.setY(0);
        patchCollection.cleanPatch(coordinates);

        Coordinates coordinates2 = new Coordinates();
        coordinates2.setX(2);
        coordinates2.setY(3);
        patchCollection.cleanPatch(coordinates2);


        assertEquals(2, patchCollection.getNumberCleanedPatches());
    }

    @Test
    public void test_cleanFourPatches() {
        PatchCollection patchCollection = new PatchCollection();
        patchCollection.add(patch1);
        patchCollection.add(patch2);
        patchCollection.add(patch3);
        patchCollection.add(patch4);

        Coordinates coordinates = new Coordinates();
        coordinates.setX(1);
        coordinates.setY(0);
        patchCollection.cleanPatch(coordinates);

        Coordinates coordinates2 = new Coordinates();
        coordinates2.setX(2);
        coordinates2.setY(2);
        patchCollection.cleanPatch(coordinates2);

        Coordinates coordinates3 = new Coordinates();
        coordinates3.setX(2);
        coordinates3.setY(3);
        patchCollection.cleanPatch(coordinates3);

        Coordinates coordinates4 = new Coordinates();
        coordinates4.setX(2);
        coordinates4.setY(4);
        patchCollection.cleanPatch(coordinates4);

        assertEquals(4, patchCollection.getNumberCleanedPatches());
    }


    @Test
    public void test_cleanSamePatch() {
        PatchCollection patchCollection = new PatchCollection();
        patchCollection.add(patch1);
        patchCollection.add(patch2);
        patchCollection.add(patch3);
        patchCollection.add(patch4);

        Coordinates coordinates = new Coordinates();
        coordinates.setX(2);
        coordinates.setY(2);
        patchCollection.cleanPatch(coordinates);

        Coordinates coordinates2 = new Coordinates();
        coordinates2.setX(2);
        coordinates2.setY(2);
        patchCollection.cleanPatch(coordinates2);

        assertEquals(1, patchCollection.getNumberCleanedPatches());
    }

    @Test
    public void test_cleanOutOfBoundPatch() {
        PatchCollection patchCollection = new PatchCollection();
        patchCollection.add(patch1);
        patchCollection.add(patch2);
        patchCollection.add(patch3);
        patchCollection.add(patch4);

        Coordinates coordinates = new Coordinates();
        coordinates.setX(-1);
        coordinates.setY(-1);
        patchCollection.cleanPatch(coordinates);

        assertEquals(0, patchCollection.getNumberCleanedPatches());
    }
}
