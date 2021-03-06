package com.epam.task4.dao.builder.part.dom;

import static com.epam.task4.constant.TreasureXmlAttibuteName.*;
import static com.epam.task4.constant.TreasureXmlTagName.*;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutIntPropertyDomPart extends DomHandlerDomPart implements Part {

    public PutIntPropertyDomPart(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void build() {
        NodeList list = handler.getCurrentElement().getElementsByTagName(INT_PROPERTY);
        for (int i = 0; i < list.getLength(); i++) {
            String propertyName = ((Element) list.item(i)).getAttribute(PROPERTY_NAME);
            Element valueElement = (Element) ((Element) list.item(i)).getElementsByTagName(VALUE).item(0);
            Integer value = Integer.parseInt(valueElement.getTextContent());
            handler.getTreasure().getProperties().put(propertyName, new Property<Integer>(value));
        }
    }
    
}
