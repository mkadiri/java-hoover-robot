package com.mkadiri.service;

import com.mkadiri.entity.HooverHistory;
import com.mkadiri.model.*;
import com.mkadiri.repository.HooverHistoryRepository;
import com.mkadiri.service.adaptor.HooverDetailsAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HooverDetailsProcessor implements HooverDetailsProcessorInterface{
    @Autowired
    private HooverHistoryRepository hooverHistoryRepository;

    @Autowired
    private HooverDetailsAdaptor hooverDetailsAdaptor;

    public HooverDetailsOutputResponse process(HooverDetailsInput hooverDetailsInput, Hoover hoover, PatchCollection patchCollection) {
        HooverHistory hooverHistory = new HooverHistory();
        hooverHistory.setHooverDetailsInput(hooverDetailsInput);

        HooverDetailsOutput hooverDetailsOutput = new HooverDetailsOutput();
        hooverDetailsOutput.setCoordinates(hoover.getCoordinates());
        hooverDetailsOutput.setPatches(patchCollection.getNumberCleanedPatches());

        hooverHistory.setHooverDetailsOutput(hooverDetailsOutput);

        this.hooverHistoryRepository.save(hooverHistory);

        return hooverDetailsAdaptor.modelToResponse(hooverDetailsOutput);
    }
}
