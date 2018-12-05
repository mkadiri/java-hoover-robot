package com.mkadiri.controller;

import com.mkadiri.exception.InvalidCoordsArrayException;
import com.mkadiri.exception.InvalidDirectionException;
import com.mkadiri.exception.InvalidPatchArrayException;
import com.mkadiri.exception.InvalidRoomArrayException;
import com.mkadiri.model.HooverDetailsInput;
import com.mkadiri.service.HooverCleanService;
import com.mkadiri.service.HooverDetailsInputRequestValidatorService;
import com.mkadiri.service.adaptor.HooverDetailsAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mkadiri.model.HooverDetailsInputRequest;
import com.mkadiri.model.HooverDetailsOutputResponse;

@Controller
@RequestMapping(path="/v1/hoover/")

public class HooverController {
    @Autowired
    private HooverCleanService hooverCleanService;

    @Autowired
    private HooverDetailsInputRequestValidatorService hooverDetailsInputRequestValidatorService;

    @Autowired
    private HooverDetailsAdaptor hooverDetailsAdaptor;

    @PostMapping(path = "/clean")
    public @ResponseBody HooverDetailsOutputResponse clean(@RequestBody HooverDetailsInputRequest hooverDetailsInputRequest)
            throws InvalidDirectionException, InvalidPatchArrayException, InvalidRoomArrayException, InvalidCoordsArrayException {

        this.hooverDetailsInputRequestValidatorService.validate(hooverDetailsInputRequest);
        HooverDetailsInput hooverDetailsInput = this.hooverDetailsAdaptor.requestToModel(hooverDetailsInputRequest);
        return this.hooverCleanService.clean(hooverDetailsInput);
    }
}