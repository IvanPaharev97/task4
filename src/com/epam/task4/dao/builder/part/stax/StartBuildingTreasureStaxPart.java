package com.epam.task4.dao.builder.part.stax;

import static com.epam.task4.constant.TreasureXmlAttibuteName.*;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Treasure;

public class StartBuildingTreasureStaxPart extends StaxHandlerPart implements Part {

    public StartBuildingTreasureStaxPart(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void build() {
        Treasure treasure = new Treasure();
        handler.setTreasure(treasure);
        treasure.setId(Integer.parseInt(handler.getReader().getAttributeValue(null, ID)));
        treasure.setCategory(handler.getReader().getAttributeValue(null, CATEGORY));
    }
    
}
