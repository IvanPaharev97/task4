package com.epam.task4.dao.builder.part.sax;

import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Treasure;

public class StartBuildingTreasureSaxPart extends SaxHandlerPart implements Part {

    public StartBuildingTreasureSaxPart(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void build() {
        Treasure treasure = new Treasure();
        handler.setTreasure(treasure);
        treasure.setId(Integer.parseInt(handler.getAttributes().getValue(ID)));
        treasure.setCategory(handler.getAttributes().getValue(CATEGORY));
    }
    
}
