package com.mkadiri.service;

import com.mkadiri.exception.InvalidCoordsArrayException;
import com.mkadiri.exception.InvalidPatchArrayException;
import com.mkadiri.exception.InvalidRoomArrayException;
import com.mkadiri.model.HooverDetailsInputRequest;
import org.springframework.stereotype.Service;

@Service
public class HooverDetailsInputRequestValidatorService {
    public void validate(HooverDetailsInputRequest request) throws InvalidRoomArrayException, InvalidCoordsArrayException, InvalidPatchArrayException {
        if (request.getRoomSize().length != 2) {
            throw new InvalidRoomArrayException();
        }

        if (request.getCoords().length != 2) {
            throw new InvalidCoordsArrayException();
        }

        for (int[] patch : request.getPatches()) {
            if (patch.length != 2) {
                throw new InvalidPatchArrayException();
            }
        }
    }
}
