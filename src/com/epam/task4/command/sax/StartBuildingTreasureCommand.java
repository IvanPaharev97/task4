package com.epam.task4.command.sax;

import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.entity.Treasure;

public class StartBuildingTreasureCommand extends SaxHandlerCommand implements Command {

    public StartBuildingTreasureCommand(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void execute() {
        Treasure treasure = new Treasure();
        handler.setTreasure(treasure);
        treasure.setId(Integer.parseInt(handler.getAttributes().getValue(ID)));
        treasure.setCategory(handler.getAttributes().getValue(CATEGORY));
    }
    
}
