package com.epam.task4.command.stax;

import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;

import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;

import com.epam.task4.command.Command;

public class GetPropertyAndParentElementNameStaxCommand extends StaxHandlerCommand implements Command {

    public GetPropertyAndParentElementNameStaxCommand(TreasureStaxHandler treasureStaxHandler) {
        super(treasureStaxHandler);
    }

    @Override
    public void execute() {
        handler.setPropertyName(handler.getReader().getAttributeValue(null, PROPERTY_NAME));
        handler.setParentElementName(handler.getElementName());
    }
}
