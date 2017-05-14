package com.epam.task4.dao.builder;

import static com.epam.task4.constant.ParseMarker.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.task4.dao.HashMapTreasureDao;
import com.epam.task4.dao.builder.part.Part;
import com.epam.task4.dao.builder.part.manager.PartManager;
import com.epam.task4.dao.exception.DaoException;
import com.epam.task4.entity.Treasure;

public class SaxTreasureDaoBuilder implements TreasureDaoBuilder {
    private static XMLReader reader;
    private InputSource inputSource;
    private TreasureSaxHandler handler;
    
    public SaxTreasureDaoBuilder(InputSource inputSource) {
        this.inputSource = inputSource;
    }
    
    @Override
    public HashMapTreasureDao buildTreasureDao() throws DaoException {
        if (reader == null) {
            initBuilder();
        }     
        try {
            reader.parse(inputSource);
        } catch (IOException | SAXException e) {
            throw new DaoException("Exeption on parsing:", e);
        }
        return new HashMapTreasureDao(handler.treasures);
    }
    
    private void initBuilder() throws DaoException {
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new DaoException("Exeption on creation XMLReader:", e);
        }
        handler = new TreasureSaxHandler();
        reader.setContentHandler(handler);
    }
    
    public static class TreasureSaxHandler extends DefaultHandler {
        private Map<Integer, Treasure> treasures = new HashMap<>();
        private Treasure treasure;
        private StringBuilder text;
        private String propertyName;
        private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        private Attributes attributes;
        private Map<String, Part> saxCommands = PartManager.getSaxCommandsMap(this);
        
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            text = new StringBuilder();
            this.attributes = attributes;
            if (saxCommands.containsKey(qName + START)) {
                saxCommands.get(qName + START).build();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (saxCommands.containsKey(qName + END)) {
                saxCommands.get(qName + END).build();
            }
        }

        @Override
        public void characters(char[] buffer, int start, int length) throws SAXException {
            text.append(buffer, start, length);
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

        public StringBuilder getText() {
            return text;
        }

        public void setText(StringBuilder text) {
            this.text = text;
        }

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public SimpleDateFormat getFormatter() {
            return formatter;
        }

        public void setFormatter(SimpleDateFormat formatter) {
            this.formatter = formatter;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }
    }
}
