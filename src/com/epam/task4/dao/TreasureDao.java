package com.epam.task4.dao;

import java.util.List;

import com.epam.task4.entity.Treasure;

public interface TreasureDao {
    Treasure getTreasureById(int id);
    Treasure getMostExpensiveTreasure();
    List<Treasure> getAllTreasures();
    List<Treasure> getTreasuresByCategory(String category);
    List<Treasure> getTreasuresByCostFromTo(double from, double to);
    <T> List<Treasure> getTreasuresByParameter(String parameterName, T parameterValue);
}
