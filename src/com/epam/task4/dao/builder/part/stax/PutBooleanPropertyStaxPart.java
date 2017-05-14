package com.epam.task4.dao.builder.part.stax;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutBooleanPropertyStaxPart extends StaxHandlerPart implements Part {

    public PutBooleanPropertyStaxPart(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void build() {
        String t = handler.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        if (!t.isEmpty()) {
            handler.getTreasure().getProperties().put(handler.getPropertyName(), 
                    new Property<Boolean>(Boolean.parseBoolean(t)));
        }
    }
    
}
