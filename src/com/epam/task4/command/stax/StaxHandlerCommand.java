package com.epam.task4.command.stax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;

public abstract class StaxHandlerCommand implements Command {
    protected TreasureStaxHandler handler;
    
    public StaxHandlerCommand(TreasureStaxHandler treasureStaxHandler) {
        this.handler = treasureStaxHandler;
    }
    
    @Override
    public abstract void execute();
}
