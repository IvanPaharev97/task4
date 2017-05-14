package com.epam.task4.dao.builder.part.stax;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;

public abstract class StaxHandlerPart implements Part {
    protected TreasureStaxHandler handler;
    
    public StaxHandlerPart(TreasureStaxHandler treasureStaxHandler) {
        this.handler = treasureStaxHandler;
    }
    
    @Override
    public abstract void build();
}
