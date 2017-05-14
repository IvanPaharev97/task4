package com.epam.task4.dao.builder.part.dom;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.entity.Treasure;

import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;
import static com.epam.task4.constants.TreasuresXmlTagNames.*;

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