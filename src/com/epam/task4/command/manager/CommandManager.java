package com.epam.task4.command.manager;

import java.util.HashMap;
import java.util.Map;

import com.epam.task4.command.Command;
import com.epam.task4.command.sax.FinishBuildingTreasureCommand;
import com.epam.task4.command.sax.GetPropertyNameCommand;
import com.epam.task4.command.sax.PutBooleanPropertyCommand;
import com.epam.task4.command.sax.PutDatePropertyCommand;
import com.epam.task4.command.sax.PutDoublePropertyCommand;
import com.epam.task4.command.sax.PutIntPropertyCommand;
import com.epam.task4.command.sax.PutStringPropertyCommand;
import com.epam.task4.command.sax.SetTreasurePriceCommand;
import com.epam.task4.command.sax.StartBuildingTreasureCommand;
import com.epam.task4.command.stax.FinishBuildingTreasureStaxCommand;
import com.epam.task4.command.stax.GetPropertyAndParentElementNameStaxCommand;
import com.epam.task4.command.stax.PutBooleanPropertyStaxCommand;
import com.epam.task4.command.stax.PutDatePropertyStaxCommand;
import com.epam.task4.command.stax.PutDoublePropertyStaxCommand;
import com.epam.task4.command.stax.PutIntPropertyStaxCommand;
import com.epam.task4.command.stax.PutStringPropertyStaxCommand;
import com.epam.task4.command.stax.SetTreasurePriceStaxCommand;
import com.epam.task4.command.stax.StartBuildingTreasureStaxCommand;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;

import static com.epam.task4.constants.TreasuresXmlTagNames.*;
import static com.epam.task4.constants.SaxAndStaxParseMarkers.*;

public class CommandManager {
    private static Map<String, Command> saxCommands;
    private static Map<String, Command> staxCommands;
    
    private CommandManager() {}
    
    public static Map<String, Command> getSaxCommandsMap(TreasureSaxHandler handler) {
        if (saxCommands == null) {
            initSaxCommands(handler);
        }
        return saxCommands;
    }
    
    public static Map<String, Command> getStaxCommandsMap(TreasureStaxHandler handler) {
        if (staxCommands == null) {
            initStaxCommands(handler);
        }
        return staxCommands;
    }

    private static void initSaxCommands(TreasureSaxHandler handler) {
        saxCommands = new HashMap<>();
        GetPropertyNameCommand getPropertyNameCommand = new GetPropertyNameCommand(handler);
        saxCommands.put(TREASURE + START, new StartBuildingTreasureCommand(handler));
        saxCommands.put(VERBAL_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(DOUBLE_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(INT_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(HAS_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(DATE_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(TREASURE + END, new FinishBuildingTreasureCommand(handler));
        saxCommands.put(VERBAL_PROPERTY + END, new PutStringPropertyCommand(handler));
        saxCommands.put(DOUBLE_PROPERTY + END, new PutDoublePropertyCommand(handler));
        saxCommands.put(INT_PROPERTY + END, new PutIntPropertyCommand(handler));
        saxCommands.put(HAS_PROPERTY + END, new PutBooleanPropertyCommand(handler));
        saxCommands.put(DATE_PROPERTY + END, new PutDatePropertyCommand(handler));
        saxCommands.put(PRICE + END, new SetTreasurePriceCommand(handler));
    }
    
    private static void initStaxCommands(TreasureStaxHandler handler) {
        staxCommands = new HashMap<>();
        GetPropertyAndParentElementNameStaxCommand getPropertyAndParentElementNameCommand = 
                new GetPropertyAndParentElementNameStaxCommand(handler);
        staxCommands.put(TREASURE + START, new StartBuildingTreasureStaxCommand(handler));
        staxCommands.put(VERBAL_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(DOUBLE_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(INT_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(HAS_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(DATE_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(TREASURE + END, new FinishBuildingTreasureStaxCommand(handler));
        staxCommands.put(VERBAL_PROPERTY + END, new PutStringPropertyStaxCommand(handler));
        staxCommands.put(DOUBLE_PROPERTY + END, new PutDoublePropertyStaxCommand(handler));
        staxCommands.put(INT_PROPERTY + END, new PutIntPropertyStaxCommand(handler));
        staxCommands.put(HAS_PROPERTY + END, new PutBooleanPropertyStaxCommand(handler));
        staxCommands.put(DATE_PROPERTY + END, new PutDatePropertyStaxCommand(handler));
        staxCommands.put(PRICE + END, new SetTreasurePriceStaxCommand(handler));
    }
}
