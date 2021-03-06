package com.epam.task4.dao.builder;

import static com.epam.task4.constant.ParseMarker.*;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.task4.constant.XmlStreamConstant;
import com.epam.task4.dao.HashMapTreasureDao;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.dao.builder.part.manager.PartManager;
import com.epam.task4.dao.exception.DaoException;
import com.epam.task4.entity.Treasure;

public class StaxTreasureDaoBuilder implements TreasureDaoBuilder {
    private static XMLStreamReader reader;
    private InputStream inputStream;
    
    public StaxTreasureDaoBuilder(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    @Override
    public HashMapTreasureDao buildTreasureDao() throws DaoException {
        if (reader == null) {
            initReader(inputStream);
        }
        Map<Integer, Treasure> treasures = null;
        TreasureStaxHandler handler = new TreasureStaxHandler(reader);
        try {
            treasures = handler.process();
        } catch (XMLStreamException e) {
            throw new DaoException("Exeption on parsing:", e);
        }
        return new HashMapTreasureDao(treasures);
    }
    
    private void initReader(InputStream inputStream) throws DaoException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            reader = factory.createXMLStreamReader(inputStream);
        } catch (XMLStreamException e) {
            throw new DaoException("Exeption on creating XMLStreamReader:", e);
        }
    }
    
    public static class TreasureStaxHandler {
        private Map<Integer, Treasure> treasures;
        private Treasure treasure;
        private String elementName;
        private String propertyName;
        private String parentElementName;
        private String text;
        private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        private XMLStreamReader reader;
        private Map<String, Part> staxCommandsMap;
        
        public TreasureStaxHandler(XMLStreamReader reader) {
            super();
            this.reader = reader;
            treasures = new HashMap<>();
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            staxCommandsMap = PartManager.getStaxCommandsMap(this);
        }

        private Map<Integer, Treasure> process() throws XMLStreamException {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                case XmlStreamConstant.START_ELEMENT:
                    elementName = reader.getLocalName();
                    if (staxCommandsMap.containsKey(elementName + START)) {
                        staxCommandsMap.get(elementName + START).build();
                    }
                    break;
                case XmlStreamConstant.CHARACTERS:
                    text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                    case "price":
                        if (staxCommandsMap.containsKey(elementName + END)) {
                            staxCommandsMap.get(elementName + END).build();
                        }
                        break;
                    case "value":
                        if (staxCommandsMap.containsKey(parentElementName + END)) {
                            staxCommandsMap.get(parentElementName + END).build();
                        }
                        break;
                    }
                    break;
                case XmlStreamConstant.END_ELEMENT:
                    elementName = reader.getLocalName();
                    if (staxCommandsMap.containsKey(elementName + END)) {
                        staxCommandsMap.get(elementName + END).build();
                    }
                    break;
                }    
            }
            return treasures;
        }

        public Map<Integer, Treasure> getTreasures() {
            return treasures;
        }

        public void setTreasures(Map<Integer, Treasure> treasures) {
            this.treasures = treasures;
        }

        public Treasure getTreasure() {
            return treasure;
        }

        public void setTreasure(Treasure treasure) {
            this.treasure = treasure;
        }

        public String getElementName() {
            return elementName;
        }

        public void setElementName(String elementName) {
            this.elementName = elementName;
        }

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public String getParentElementName() {
            return parentElementName;
        }

        public void setParentElementName(String parentElementName) {
            this.parentElementName = parentElementName;
        }

        public SimpleDateFormat getFormatter() {
            return formatter;
        }

        public void setFormatter(SimpleDateFormat formatter) {
            this.formatter = formatter;
        }

        public XMLStreamReader getReader() {
            return reader;
        }

        public void setReader(XMLStreamReader reader) {
            this.reader = reader;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
