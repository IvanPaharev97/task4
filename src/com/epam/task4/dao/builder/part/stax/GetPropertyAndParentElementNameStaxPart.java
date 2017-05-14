package com.epam.task4.dao.builder.part.stax;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;

import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;

public class GetPropertyAndParentElementNameStaxPart extends StaxHandlerPart implements Part {

    public GetPropertyAndParentElementNameStaxPart(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void build() {
        handler.setPropertyName(handler.getReader().getAttributeValue(null, PROPERTY_NAME));
        handler.setParentElementName(handler.getElementName());
    }
}
