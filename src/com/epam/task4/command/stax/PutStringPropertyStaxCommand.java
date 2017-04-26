package com.epam.task4.command.stax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.entity.Property;

public class PutStringPropertyStaxCommand extends StaxHandlerCommand implements Command {

    public PutStringPropertyStaxCommand(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void execute() {
        String[] ar = handler.getText().replaceAll("\n", "").replaceAll("\t", "").split(" ");
        String t = "";
        for (int i = 0; i < ar.length - 1; i++) {
            t += ar[i] + " ";
        }
        t += ar[ar.length - 1];
        if (!t.isEmpty()) {
            handler.getTreasure().getProperties().put(handler.getPropertyName(), 
                    new Property<String>(t));
        }
    }
    
}
