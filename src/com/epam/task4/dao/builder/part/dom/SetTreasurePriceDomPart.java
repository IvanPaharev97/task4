package com.epam.task4.dao.builder.part.dom;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.dao.builder.part.Part;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SetTreasurePriceDomPart extends DomHandlerDomPart implements Part {

    public SetTreasurePriceDomPart(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void build() {
        NodeList list = handler.getCurrentElement().getElementsByTagName("price");
        if (list.getLength() != 0) {
            Element price = (Element) list.item(0);
            handler.getTreasure().setPrice(Double.parseDouble(price.getTextContent()));   
        }
    }

}
