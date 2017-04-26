package com.epam.task4.dao.builder;

import com.epam.task4.dao.TreasureDao;
import com.epam.task4.dao.exception.DaoException;

public interface TreasureDaoBuilder { 
    TreasureDao buildTreasureDao() throws DaoException;
}
