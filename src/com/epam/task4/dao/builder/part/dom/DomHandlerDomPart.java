package com.epam.task4.dao.builder.part.dom;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.dao.builder.part.Part;

public abstract class DomHandlerDomPart implements Part {
    protected TreasureDomHandler handler;
    
    public DomHandlerDomPart(TreasureDomHandler treasureDomHandler) {
        this.handler = treasureDomHandler;
    }
    
    @Override
    public abstract void build();
}
