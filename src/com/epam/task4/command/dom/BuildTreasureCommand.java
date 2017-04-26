package com.epam.task4.command.dom;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;

public class BuildTreasureCommand extends DomHandlerCommand implements Command {

    public BuildTreasureCommand(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void execute() {
        new PutStringPropertyDomCommand(handler).execute();
        new PutDoublePropertyDomCommand(handler).execute();
        new PutIntPropertyDomCommand(handler).execute();
        new PutBooleanPropertyDomCommand(handler).execute();
        new PutDatePropertyDomCommand(handler).execute();
        new SetTreasurePriceDomCommand(handler).execute();
    }
    
}
