package com.epam.task4.command.sax;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;

import static com.epam.task4.constants.TreasuresXmlAttibutesNames.*;

import com.epam.task4.command.Command;

public class GetPropertyNameCommand extends SaxHandlerCommand implements Command {

    public GetPropertyNameCommand(TreasureSaxHandler treasureSaxHandler) {
        super(treasureSaxHandler);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void execute() {
        handler.setPropertyName(handler.getAttributes().getValue(PROPERTY_NAME));
    }
}
