package com.epam.task4.dao.builder.part.sax;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;

public abstract class SaxHandlerPart implements Part {
    protected TreasureSaxHandler handler;
    
    public SaxHandlerPart(TreasureSaxHandler treasureSaxHandler) {
        this.handler = treasureSaxHandler;
    }
    
    @Override
    public abstract void build();
}
