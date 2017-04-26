package com.epam.task4.command.stax;

import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.entity.Treasure;

public class StartBuildingTreasureStaxCommand extends StaxHandlerCommand implements Command {

    public StartBuildingTreasureStaxCommand(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void execute() {
        Treasure treasure = new Treasure();
        handler.setTreasure(treasure);
        treasure.setId(Integer.parseInt(handler.getReader().getAttributeValue(null, ID)));
        treasure.setCategory(handler.getReader().getAttributeValue(null, CATEGORY));
    }
    
}
