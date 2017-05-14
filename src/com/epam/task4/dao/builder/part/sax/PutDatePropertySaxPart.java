package com.epam.task4.dao.builder.part.sax;

import java.text.ParseException;
import java.util.Date;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutDatePropertySaxPart extends SaxHandlerPart implements Part {

    public PutDatePropertySaxPart(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
    }

    @Override
    public void build() {
        String t = handler.getText().toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
        try {
            handler.getTreasure().getProperties().put(handler.getPropertyName(),
                    new Property<Date>(handler.getFormatter().parse(t)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}
