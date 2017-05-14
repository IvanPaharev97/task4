package com.epam.task4.dao.builder.part.dom;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.dao.builder.part.Part;

public class BuildTreasureDomPart extends DomHandlerDomPart implements Part {

    public BuildTreasureDomPart(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void build() {
        new PutStringPropertyDomPart(handler).build();
        new PutDoublePropertyDomPart(handler).build();
        new PutIntPropertyDomPart(handler).build();
        new PutBooleanPropertyDomPart(handler).build();
        new PutDatePropertyDomPart(handler).build();
        new SetTreasurePriceDomPart(handler).build();
    }
    
}
