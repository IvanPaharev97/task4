package com.epam.task4.command.dom;

import java.text.ParseException;
import java.util.Date;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.epam.task4.command.Command;
import com.epam.task4.dao.builder.DomTreasureDaoBuilder.TreasureDomHandler;
import com.epam.task4.entity.Property;
import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;
import static com.epam.task4.constants.TreasuresXmlTagNames.*;

public class PutDatePropertyDomCommand extends DomHandlerCommand implements Command {

    public PutDatePropertyDomCommand(TreasureDomHandler treasureDomHandler) {
        super(treasureDomHandler);
    }

    @Override
    public void execute() {
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
