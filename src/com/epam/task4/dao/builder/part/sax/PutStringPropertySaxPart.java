package com.epam.task4.dao.builder.part.sax;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutStringPropertySaxPart extends SaxHandlerPart implements Part {

    public PutStringPropertySaxPart(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void build() {
        String[] ar = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").split(" ");
        String t = "";
        for (int i = 0; i < ar.length - 1; i++) {
            t += ar[i] + " ";
        }
        t += ar[ar.length - 1];
        handler.getTreasure().getProperties().put(handler.getPropertyName(), new Property<String>(t));
    }
    
}
