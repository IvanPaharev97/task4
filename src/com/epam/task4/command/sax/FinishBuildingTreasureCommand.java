package com.epam.task4.command.sax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.entity.Treasure;

public class FinishBuildingTreasureCommand extends SaxHandlerCommand implements Command {

    public FinishBuildingTreasureCommand(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void execute() {
        Treasure treasure = handler.getTreasure();
        handler.getTreasures().put(treasure.getId(), treasure);
        handler.setTreasure(null);
    }

}
