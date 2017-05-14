package com.epam.task4.dao.builder.part.dom;

import static com.epam.task4.constant.TreasureXmlAttibuteName.*;
import static com.epam.task4.constant.TreasureXmlTagName.*;

import java.text.ParseException;
import java.util.Date;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Property;

public class PutDatePropertyDomPart extends DomHandlerDomPart implements Part {

    public PutDatePropertyDomPart(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void build() {
        NodeList list = handler.getCurrentElement().getElementsByTagName(DATE_PROPERTY);
        for (int i = 0; i < list.getLength(); i++) {
            String propertyName = ((Element) list.item(i)).getAttribute(PROPERTY_NAME);
            Element valueElement = (Element) ((Element) list.item(i)).getElementsByTagName(VALUE).item(0);
            Date value = null;
            try {
                value = handler.getFormatter().parse(valueElement.getTextContent());
            } catch (DOMException | ParseException e) {
                e.printStackTrace();
            }
            handler.getTreasure().getProperties().put(propertyName, new Property<Date>(value));
        }
    }
    
}
