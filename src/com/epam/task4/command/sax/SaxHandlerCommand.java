package com.epam.task4.command.sax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;

public abstract class SaxHandlerCommand implements Command {
    protected TreasureSaxHandler handler;
    
    public SaxHandlerCommand(TreasureSaxHandler treasureSaxHandler) {
        this.handler = treasureSaxHandler;
    }
    
    @Override
    public abstract void execute();
}
