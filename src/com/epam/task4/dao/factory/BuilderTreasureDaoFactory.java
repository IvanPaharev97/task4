package com.epam.task4.dao.factory;

import com.epam.task4.dao.TreasureDao;
import com.epam.task4.dao.builder.TreasureDaoBuilder;
import com.epam.task4.dao.exception.DaoException;

public class BuilderTreasureDaoFactory implements TreasureDaoFactory {
    private TreasureDaoBuilder treasureDaoBuilder;
    
    public TreasureDaoBuilder getTreasureDaoBuilder() {
        return treasureDaoBuilder;
    }

    public void setTreasureDaoBuilder(TreasureDaoBuilder treasureDaoBuilder) {
        this.treasureDaoBuilder = treasureDaoBuilder;
    }

    @Override
    public TreasureDao getTreasureDao() throws DaoException {
        return treasureDaoBuilder.buildTreasureDao();
    }
}
