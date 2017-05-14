package com.epam.task4.dao.builder.part.sax;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutDoublePropertySaxPart extends SaxHandlerPart implements Part {

    public PutDoublePropertySaxPart(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void build() {
        String t = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        handler.getTreasure().getProperties().put(handler.getPropertyName(), 
                new Property<Double>(Double.parseDouble(t)));
    }
}
