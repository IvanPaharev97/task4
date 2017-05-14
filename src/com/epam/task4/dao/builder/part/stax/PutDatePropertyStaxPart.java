package com.epam.task4.dao.builder.part.stax;

import java.text.ParseException;
import java.util.Date;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutDatePropertyStaxPart extends StaxHandlerPart implements Part {

    public PutDatePropertyStaxPart(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void build() {
        String t = handler.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        if (!t.isEmpty()) {
            try {
                handler.getTreasure().getProperties().put(handler.getPropertyName(),
                        new Property<Date>(handler.getFormatter().parse(t)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    
}
