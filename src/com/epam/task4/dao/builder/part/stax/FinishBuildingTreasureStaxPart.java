package com.epam.task4.dao.builder.part.stax;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Treasure;

public class FinishBuildingTreasureStaxPart extends StaxHandlerPart implements Part {

    public FinishBuildingTreasureStaxPart(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void build() {
        Treasure treasure = handler.getTreasure();
        handler.getTreasures().put(treasure.getId(), treasure);
        handler.setTreasure(null);
    }

}
