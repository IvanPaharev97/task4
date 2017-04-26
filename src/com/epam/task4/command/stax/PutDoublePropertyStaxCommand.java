package com.epam.task4.command.stax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.entity.Property;

public class PutDoublePropertyStaxCommand extends StaxHandlerCommand implements Command {

    public PutDoublePropertyStaxCommand(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void execute() {
        String t = handler.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        if (!t.isEmpty()) {
            handler.getTreasure().getProperties().put(handler.getPropertyName(), 
                    new Property<Double>(Double.parseDouble(t)));
        }
    }
}
