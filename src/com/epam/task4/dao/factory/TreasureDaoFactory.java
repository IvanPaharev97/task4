package com.epam.task4.dao.factory;

import com.epam.task4.dao.TreasureDao;
import com.epam.task4.dao.exception.DaoException;

public interface TreasureDaoFactory {
    TreasureDao getTreasureDao() throws DaoException;
}
