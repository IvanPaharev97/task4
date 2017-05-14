package com.epam.task4.dao.builder.part.stax;

import static com.epam.task4.constant.TreasureXmlAttibuteName.*;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;

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
