package com.epam.task4.dao.builder.part.sax;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.part.Part;

import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;

public class GetPropertyNameSaxPart extends SaxHandlerPart implements Part {

    public GetPropertyNameSaxPart(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void build() {
        handler.setPropertyName(handler.getAttributes().getValue(PROPERTY_NAME));
    }
}
