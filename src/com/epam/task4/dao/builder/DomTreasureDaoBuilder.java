package com.epam.task4.dao.builder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.epam.task4.command.dom.BuildAllTreasuresCommand;
import com.epam.task4.dao.exception.DaoException;
import com.epam.task4.dao.impl.HashMapTreasureDao;
import com.epam.task4.entity.Treasure;

public class DomTreasureDaoBuilder implements TreasureDaoBuilder {
    private static DocumentBuilderFactory documentBuilderFactory;
    private static DocumentBuilder documentBuilder;
    private Document document;
    private InputSource inputSource;
    
    public DomTreasureDaoBuilder(InputSource inputSource) {
        super();
        this.inputSource = inputSource;
    }

    @Override
    public HashMapTreasureDao buildTreasureDao() throws DaoException {
        if (documentBuilder == null) {
            initBuilder();
        }
        parseDocument(inputSource);
        TreasureDomHandler handler = new TreasureDomHandler(document);
        return new HashMapTreasureDao(handler.process());
    }
    
    private void parseDocument(InputSource inputSource) throws DaoException {
        try {
            document = documentBuilder.parse(inputSource);
        } catch (SAXException | IOException e) {
            DaoException persistException = 
                    new DaoException("Exeption on parsing:", e);
            throw persistException;
        }
        document.normalize();
    }

    private void initBuilder() throws DaoException {
        if (documentBuilderFactory == null) {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
        }
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            DaoException persistException = 
                    new DaoException("Exeption on creating DocumentBuilder:", e);
            throw persistException;
        }
        
    }
    
    public static class TreasureDomHandler {
        private Document document;
        private Treasure treasure;
        private Element currentElement;
        private Map<Integer, Treasure> treasures;
        private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        public TreasureDomHandler(Document document) {
            this.document = document;
            treasures = new HashMap<>();
        }
        
        private Map<Integer, Treasure> process() throws DaoException {
            new BuildAllTreasuresCommand(this).execute();
            return treasures;
        }

        public Document getDocument() {
            return document;
        }

        public void setDocument(Document document) {
            this.document = document;
        }

        public Treasure getTreasure() {
            return treasure;
        }

        public void setTreasure(Treasure treasure) {
            this.treasure = treasure;
        }

        public Map<Integer, Treasure> getTreasures() {
            return treasures;
        }

        public void setTreasures(Map<Integer, Treasure> treasures) {
            this.treasures = treasures;
        }

        public SimpleDateFormat getFormatter() {
            return formatter;
        }

        public void setFormatter(SimpleDateFormat formatter) {
            this.formatter = formatter;
        }

        public Element getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(Element currentElement) {
            this.currentElement = currentElement;
        }
        
    }
}
