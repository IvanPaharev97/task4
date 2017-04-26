package com.epam.task4.command.sax;

import java.text.ParseException;
import java.util.Date;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.entity.Property;

public class PutDatePropertyCommand extends SaxHandlerCommand implements Command {

    public PutDatePropertyCommand(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void execute() {
        String t = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        try {
            handler.getTreasure().getProperties().put(handler.getPropertyName(),
                    new Property<Date>(handler.getFormatter().parse(t)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}
