package com.epam.task4.dao.builder.part.stax;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;

public class SetTreasurePriceStaxPart extends StaxHandlerPart implements Part {

    public SetTreasurePriceStaxPart(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void build() {
        String t = handler.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        if (!t.isEmpty()) {
            handler.getTreasure().setPrice(Double.parseDouble(t));
        }
    }

}
