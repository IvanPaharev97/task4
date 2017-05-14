package com.epam.task4.dao.builder.part.manager;

import static com.epam.task4.constant.ParseMarker.*;
import static com.epam.task4.constant.TreasureXmlTagName.*;

import java.util.HashMap;
import java.util.Map;

import com.epam.task4.dao.builder.SaxTreasureDaoBuilder.TreasureSaxHandler;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder.TreasureStaxHandler;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.dao.builder.part.sax.FinishBuildingTreasureSaxPart;
import com.epam.task4.dao.builder.part.sax.GetPropertyNameSaxPart;
import com.epam.task4.dao.builder.part.sax.PutBooleanPropertySaxPart;
import com.epam.task4.dao.builder.part.sax.PutDatePropertySaxPart;
import com.epam.task4.dao.builder.part.sax.PutDoublePropertySaxPart;
import com.epam.task4.dao.builder.part.sax.PutIntPropertySaxPart;
import com.epam.task4.dao.builder.part.sax.PutStringPropertySaxPart;
import com.epam.task4.dao.builder.part.sax.SetTreasurePriceSaxPart;
import com.epam.task4.dao.builder.part.sax.StartBuildingTreasureSaxPart;
import com.epam.task4.dao.builder.part.stax.FinishBuildingTreasureStaxPart;
import com.epam.task4.dao.builder.part.stax.GetPropertyAndParentElementNameStaxPart;
import com.epam.task4.dao.builder.part.stax.PutBooleanPropertyStaxPart;
import com.epam.task4.dao.builder.part.stax.PutDatePropertyStaxPart;
import com.epam.task4.dao.builder.part.stax.PutDoublePropertyStaxPart;
import com.epam.task4.dao.builder.part.stax.PutIntPropertyStaxPart;
import com.epam.task4.dao.builder.part.stax.PutStringPropertyStaxPart;
import com.epam.task4.dao.builder.part.stax.SetTreasurePriceStaxPart;
import com.epam.task4.dao.builder.part.stax.StartBuildingTreasureStaxPart;

public class PartManager {
    private static Map<String, Part> saxCommands;
    private static Map<String, Part> staxCommands;
    
    private PartManager() {}
    
    public static Map<String, Part> getSaxCommandsMap(TreasureSaxHandler handler) {
        if (saxCommands == null) {
            initSaxCommands(handler);
        }
        return saxCommands;
    }
    
    public static Map<String, Part> getStaxCommandsMap(TreasureStaxHandler handler) {
        if (staxCommands == null) {
            initStaxCommands(handler);
        }
        return staxCommands;
    }

    private static void initSaxCommands(TreasureSaxHandler handler) {
        saxCommands = new HashMap<>();
        GetPropertyNameSaxPart getPropertyNameCommand = new GetPropertyNameSaxPart(handler);
        saxCommands.put(TREASURE + START, new StartBuildingTreasureSaxPart(handler));
        saxCommands.put(VERBAL_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(DOUBLE_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(INT_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(HAS_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(DATE_PROPERTY + START, getPropertyNameCommand);
        saxCommands.put(TREASURE + END, new FinishBuildingTreasureSaxPart(handler));
        saxCommands.put(VERBAL_PROPERTY + END, new PutStringPropertySaxPart(handler));
        saxCommands.put(DOUBLE_PROPERTY + END, new PutDoublePropertySaxPart(handler));
        saxCommands.put(INT_PROPERTY + END, new PutIntPropertySaxPart(handler));
        saxCommands.put(HAS_PROPERTY + END, new PutBooleanPropertySaxPart(handler));
        saxCommands.put(DATE_PROPERTY + END, new PutDatePropertySaxPart(handler));
        saxCommands.put(PRICE + END, new SetTreasurePriceSaxPart(handler));
    }
    
    private static void initStaxCommands(TreasureStaxHandler handler) {
        staxCommands = new HashMap<>();
        GetPropertyAndParentElementNameStaxPart getPropertyAndParentElementNameCommand = 
                new GetPropertyAndParentElementNameStaxPart(handler);
        staxCommands.put(TREASURE + START, new StartBuildingTreasureStaxPart(handler));
        staxCommands.put(VERBAL_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(DOUBLE_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(INT_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(HAS_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(DATE_PROPERTY + START, getPropertyAndParentElementNameCommand);
        staxCommands.put(TREASURE + END, new FinishBuildingTreasureStaxPart(handler));
        staxCommands.put(VERBAL_PROPERTY + END, new PutStringPropertyStaxPart(handler));
        staxCommands.put(DOUBLE_PROPERTY + END, new PutDoublePropertyStaxPart(handler));
        staxCommands.put(INT_PROPERTY + END, new PutIntPropertyStaxPart(handler));
        staxCommands.put(HAS_PROPERTY + END, new PutBooleanPropertyStaxPart(handler));
        staxCommands.put(DATE_PROPERTY + END, new PutDatePropertyStaxPart(handler));
        staxCommands.put(PRICE + END, new SetTreasurePriceStaxPart(handler));
    }
}
