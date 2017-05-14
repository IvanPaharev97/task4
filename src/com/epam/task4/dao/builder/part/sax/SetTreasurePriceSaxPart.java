package com.epam.task4.dao.builder.part.sax;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;

public class SetTreasurePriceSaxPart extends SaxHandlerPart implements Part {

    public SetTreasurePriceSaxPart(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void build() {
        String t = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        handler.getTreasure().setPrice(Double.parseDouble(t));
    }

}
