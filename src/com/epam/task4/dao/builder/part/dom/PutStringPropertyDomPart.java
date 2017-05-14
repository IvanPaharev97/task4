package com.epam.task4.dao.builder.part.dom;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;
import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;
import static com.epam.task4.constants.TreasuresXmlTagNames.*;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class PutStringPropertyDomPart extends DomHandlerDomPart implements Part {

    public PutStringPropertyDomPart(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void build() {
        NodeList list = handler.getCurrentElement().getElementsByTagName(VERBAL_PROPERTY);
        for (int i = 0; i < list.getLength(); i++) {
            String propertyName = ((Element) list.item(i)).getAttribute(PROPERTY_NAME);
            Element valueElement = (Element) ((Element) list.item(i)).getElementsByTagName(VALUE).item(0);
            String value = valueElement.getTextContent();
            handler.getTreasure().getProperties().put(propertyName, new Property<String>(value));
        }
    }
    
}
