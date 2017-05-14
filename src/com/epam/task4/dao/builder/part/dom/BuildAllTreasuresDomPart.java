package com.epam.task4.dao.builder.part.dom;

import static com.epam.task4.constant.TreasureXmlAttibuteName.*;
import static com.epam.task4.constant.TreasureXmlTagName.*;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Treasure;

public class BuildAllTreasuresDomPart extends DomHandlerDomPart implements Part {

    public BuildAllTreasuresDomPart(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void build() {
        Element root = handler.getDocument().getDocumentElement();
        NodeList treasureNodes = root.getElementsByTagName(TREASURE);
        for (int i = 0; i < treasureNodes.getLength(); i++) {
            Treasure treasure = new Treasure();
            Element currentElement = (Element) treasureNodes.item(i);
            handler.setCurrentElement(currentElement);
            treasure.setId(Integer.parseInt(currentElement.getAttribute(ID)));
            treasure.setCategory(currentElement.getAttribute(CATEGORY));
            handler.setTreasure(treasure);
            new BuildTreasureDomPart(handler).build();
            handler.getTreasures().put(treasure.getId(), handler.getTreasure());
        }
    }

}
