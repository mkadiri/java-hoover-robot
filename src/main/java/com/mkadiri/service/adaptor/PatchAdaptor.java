package com.mkadiri.service.adaptor;

import com.mkadiri.model.Coordinates;
import com.mkadiri.model.Patch;
import com.mkadiri.model.PatchCollection;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatchAdaptor {
    public PatchCollection listToPatchCollection(List<Coordinates> coordinatesList) {
        PatchCollection patchCollection = new PatchCollection();

        for (Coordinates coordinates : coordinatesList) {
            patchCollection.add(new Patch(coordinates));
        }

        return patchCollection;
    }
}
