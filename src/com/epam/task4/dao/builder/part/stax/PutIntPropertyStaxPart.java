package com.epam.task4.dao.builder.part.stax;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutIntPropertyStaxPart extends StaxHandlerPart implements Part {

    public PutIntPropertyStaxPart(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void build() {
        String t = handler.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        if (!t.isEmpty()) {
            handler.getTreasure().getProperties().put(handler.getPropertyName(), 
                    new Property<Integer>(Integer.parseInt(t)));
        }
    }
    
}
