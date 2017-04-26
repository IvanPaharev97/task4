package com.epam.task4.command.sax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.entity.Property;

public class PutIntPropertyCommand extends SaxHandlerCommand implements Command {

    public PutIntPropertyCommand(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void execute() {
        String t = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        handler.getTreasure().getProperties().put(handler.getPropertyName(), 
                new Property<Integer>(Integer.parseInt(t)));
    }
    
}
