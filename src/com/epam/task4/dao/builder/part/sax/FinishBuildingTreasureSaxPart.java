package com.epam.task4.dao.builder.part.sax;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Treasure;

public class FinishBuildingTreasureSaxPart extends SaxHandlerPart implements Part {

    public FinishBuildingTreasureSaxPart(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void build() {
        Treasure treasure = handler.getTreasure();
        handler.getTreasures().put(treasure.getId(), treasure);
        handler.setTreasure(null);
    }

}
