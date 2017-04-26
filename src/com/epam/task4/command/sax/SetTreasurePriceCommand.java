package com.epam.task4.command.sax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;

public class SetTreasurePriceCommand extends SaxHandlerCommand implements Command {

    public SetTreasurePriceCommand(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void execute() {
        String t = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        handler.getTreasure().setPrice(Double.parseDouble(t));
    }

}
