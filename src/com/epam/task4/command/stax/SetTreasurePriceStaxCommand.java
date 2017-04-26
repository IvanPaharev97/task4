package com.epam.task4.command.stax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;

public class SetTreasurePriceStaxCommand extends StaxHandlerCommand implements Command {

    public SetTreasurePriceStaxCommand(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void execute() {
        String t = handler.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        if (!t.isEmpty()) {
            handler.getTreasure().setPrice(Double.parseDouble(t));
        }
    }

}
