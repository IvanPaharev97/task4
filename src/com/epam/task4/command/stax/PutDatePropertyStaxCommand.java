package com.epam.task4.command.stax;

import java.text.ParseException;
import java.util.Date;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.entity.Property;

public class PutDatePropertyStaxCommand extends StaxHandlerCommand implements Command {

    public PutDatePropertyStaxCommand(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void execute() {
        String t = handler.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        if (!t.isEmpty()) {
            try {
                handler.getTreasure().getProperties().put(handler.getPropertyName(),
                        new Property<Date>(handler.getFormatter().parse(t)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    
}
