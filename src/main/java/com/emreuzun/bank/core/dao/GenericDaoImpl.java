package com.emreuzun.bank.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class GenericDaoImpl implements GenericDao {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void createQuery(String query) {
        Connection connection = sql2o.open();
        connection.createQuery(query).executeUpdate();
    }
}
