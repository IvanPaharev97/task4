package com.epam.task4.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.task4.dao.TreasureDao;
import com.epam.task4.entity.Treasure;

public class HashMapTreasureDao implements TreasureDao {
    private Map<Integer, Treasure> treasures;
    
    public HashMapTreasureDao(Map<Integer, Treasure> treasures) {
        this.treasures = treasures;
    }
    
    @Override
    public Treasure getTreasureById(int id) {
        return treasures.get(id);
    }

    @Override
    public Treasure getMostExpensiveTreasure() {
        double price = 0;
        Treasure expensiveTreasure = null;
        for (Treasure treasure : treasures.values()) {
            if (treasure.getPrice() > price) {
                expensiveTreasure = treasure;
            }
        }
        return expensiveTreasure;
    }

    @Override
    public List<Treasure> getAllTreasures() {
        return new ArrayList<>(treasures.values());
    }

    @Override
    public List<Treasure> getTreasuresByCategory(String category) {
        List<Treasure> categoryTreasures = new ArrayList<>();
        for (Treasure treasure : treasures.values()) {
            if (treasure.getCategory().equals(category)) {
                categoryTreasures.add(treasure);
            }
        }
        return categoryTreasures;
    }

    @Override
    public List<Treasure> getTreasuresByCostFromTo(double from, double to) {
        List<Treasure> costTreasures = new ArrayList<>();
        for (Treasure treasure : treasures.values()) {
            if (treasure.getPrice() >= from && treasure.getPrice() <= to) {
                costTreasures.add(treasure);
            }
        }
        return costTreasures;
    }

    @Override
    public <T> List<Treasure> getTreasuresByParameter(String parameterName, T parameterValue) {
        List<Treasure> parameterTreasures = new ArrayList<>();
        for (Treasure treasure : treasures.values()) {
            if (parameterValue.equals(treasure.getProperties().get(parameterName))) {
                parameterTreasures.add(treasure);
            }
        }
        return parameterTreasures;
    }
}
