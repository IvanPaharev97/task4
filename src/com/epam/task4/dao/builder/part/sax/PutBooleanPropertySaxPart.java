package com.epam.task4.dao.builder.part.sax;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutBooleanPropertySaxPart extends SaxHandlerPart implements Part {

    public PutBooleanPropertySaxPart(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void build() {
        String t = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        handler.getTreasure().getProperties().put(handler.getPropertyName(), 
                new Property<Boolean>(Boolean.parseBoolean(t)));
    }
    
}
