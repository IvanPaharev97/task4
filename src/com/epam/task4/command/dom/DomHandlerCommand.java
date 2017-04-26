package com.epam.task4.command.dom;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;

public abstract class DomHandlerCommand implements Command {
    protected TreasureDomHandler handler;
    
    public DomHandlerCommand(TreasureDomHandler treasureDomHandler) {
        this.handler = treasureDomHandler;
    }
    
    @Override
    public abstract void execute();
}
