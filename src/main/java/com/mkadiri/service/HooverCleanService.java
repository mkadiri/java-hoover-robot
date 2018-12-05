package com.mkadiri.service;

import com.mkadiri.exception.InvalidDirectionException;
import com.mkadiri.model.*;
import com.mkadiri.service.adaptor.PatchAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HooverCleanService {
    @Autowired
    private PatchAdaptor patchAdaptor;

    @Autowired
    private HooverDetailsProcessorInterface hooverDetailsProcessor;

    public HooverDetailsOutputResponse clean (HooverDetailsInput hooverDetailsInput) throws InvalidDirectionException {
        Hoover hoover = new Hoover(hooverDetailsInput.getCoordinates());
        Room room = new Room(hooverDetailsInput.getRoomSize().getX(), hooverDetailsInput.getRoomSize().getY());

        PatchCollection patchCollection = this.patchAdaptor.listToPatchCollection(hooverDetailsInput.getPatches());
        patchCollection.cleanPatch(hoover.getCoordinates());

        for (char direction : hooverDetailsInput.getInstructions().toCharArray()) {
            hoover.move(direction, room);
            patchCollection.cleanPatch(hoover.getCoordinates());
        }

        return this.hooverDetailsProcessor.process(hooverDetailsInput, hoover, patchCollection);
    }
}