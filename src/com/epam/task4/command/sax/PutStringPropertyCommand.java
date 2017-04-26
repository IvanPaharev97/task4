package com.epam.task4.command.sax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.entity.Property;

public class PutStringPropertyCommand extends SaxHandlerCommand implements Command {

    public PutStringPropertyCommand(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void execute() {
        String[] ar = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").split(" ");
        String t = "";
        for (int i = 0; i < ar.length - 1; i++) {
            t += ar[i] + " ";
        }
        t += ar[ar.length - 1];
        handler.getTreasure().getProperties().put(handler.getPropertyName(), new Property<String>(t));
    }
    
}
