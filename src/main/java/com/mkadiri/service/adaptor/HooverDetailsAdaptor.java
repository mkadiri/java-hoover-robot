package com.mkadiri.service.adaptor;

import com.mkadiri.model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HooverDetailsAdaptor {

    public HooverDetailsInput requestToModel(HooverDetailsInputRequest request){
        HooverDetailsInput hooverDetailsInput = new HooverDetailsInput();

        Coordinates roomSize = new Coordinates();
        roomSize.setX(request.getRoomSize()[0]);
        roomSize.setY(request.getRoomSize()[1]);
        hooverDetailsInput.setRoomSize(roomSize);

        Coordinates coordinates = new Coordinates();
        coordinates.setX(request.getCoords()[0]);
        coordinates.setY(request.getCoords()[1]);
        hooverDetailsInput.setCoordinates(coordinates);

        hooverDetailsInput.setInstructions(request.getInstructions());
        List<Coordinates> coordPatches = new ArrayList<>();

        for (int[] patch : request.getPatches()) {
            Coordinates coordPatch = new Coordinates();
            coordPatch.setX(patch[0]);
            coordPatch.setY(patch[1]);

            coordPatches.add(coordPatch);

            hooverDetailsInput.setPatches(coordPatches);
        }

        return hooverDetailsInput;
    }

    public HooverDetailsOutputResponse modelToResponse(HooverDetailsOutput hooverDetailsOutput) {
        HooverDetailsOutputResponse response = new HooverDetailsOutputResponse();

        int[] coords = new int[]{hooverDetailsOutput.getCoordinates().getX(), hooverDetailsOutput.getCoordinates().getY()};
        response.setCoords(coords);

        response.setPatches(hooverDetailsOutput.getPatches());

        return response;
    }
}