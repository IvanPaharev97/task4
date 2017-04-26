package com.epam.task4.command.stax;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.entity.Treasure;

public class FinishBuildingTreasureStaxCommand extends StaxHandlerCommand implements Command {

    public FinishBuildingTreasureStaxCommand(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void execute() {
        Treasure treasure = handler.getTreasure();
        handler.getTreasures().put(treasure.getId(), treasure);
        handler.setTreasure(null);
    }

}
