package com.mkadiri.service;

import com.mkadiri.model.*;

interface HooverDetailsProcessorInterface {
    HooverDetailsOutputResponse process(HooverDetailsInput hooverDetailsInput, Hoover hoover, PatchCollection patchCollection);
}
