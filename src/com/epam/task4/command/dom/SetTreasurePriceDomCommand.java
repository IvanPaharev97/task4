package com.epam.task4.command.dom;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SetTreasurePriceDomCommand extends DomHandlerCommand implements Command {

    public SetTreasurePriceDomCommand(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void execute() {
        NodeList list = handler.getCurrentElement().getElementsByTagName("price");
        if (list.getLength() != 0) {
            Element price = (Element) list.item(0);
            handler.getTreasure().setPrice(Double.parseDouble(price.getTextContent()));   
        }
    }

}
