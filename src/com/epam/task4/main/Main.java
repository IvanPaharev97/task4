package com.epam.task4.main;

import java.io.FileInputStream;
import java.util.List;

import org.xml.sax.InputSource;

import com.epam.task4.dao.builder.DomTreasureDaoBuilder;
import com.epam.task4.dao.builder.SaxTreasureDaoBuilder;
import com.epam.task4.dao.builder.StaxTreasureDaoBuilder;
import com.epam.task4.dao.factory.BuilderTreasureDaoFactory;
import com.epam.task4.entity.Treasure;


public class Main {

    public static void main(String[] args) throws Exception {
        BuilderTreasureDaoFactory daoFactory = new BuilderTreasureDaoFactory();
        daoFactory.setTreasureDaoBuilder(
                new SaxTreasureDaoBuilder(new InputSource("resources/treasures.xml")));
        List<Treasure> treasures = daoFactory.getTreasureDao().getAllTreasures();
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
        daoFactory.setTreasureDaoBuilder(
                new StaxTreasureDaoBuilder(new FileInputStream("resources/treasures.xml")));
        treasures = daoFactory.getTreasureDao().getAllTreasures();
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
        daoFactory.setTreasureDaoBuilder(
                new DomTreasureDaoBuilder(new InputSource("resources/treasures.xml")));
        treasures = daoFactory.getTreasureDao().getAllTreasures();
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
        
    }

}
