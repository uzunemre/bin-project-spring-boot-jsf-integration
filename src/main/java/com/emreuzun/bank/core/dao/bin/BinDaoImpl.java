package com.emreuzun.bank.core.dao.bin;

import com.emreuzun.bank.core.model.Bin;
import com.emreuzun.bank.core.util.Sql2OUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class BinDaoImpl implements BinDao {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void save(Bin bin) {
        String insertSql =
                "INSERT INTO BIN(ISSUER_ID,BIN,BIN_START,BIN_END) " +
                        "values (:issuerIdParam, :binParam, :binStartPram, :binEndParam)";
        Connection con = sql2o.open();
        con.createQuery(insertSql)
                .addParameter("issuerIdParam", bin.getIssuerId())
                .addParameter("binParam", bin.getBin())
                .addParameter("binStartPram", bin.getBinStart())
                .addParameter("binEndParam", bin.getBinEnd())
                .executeUpdate();
    }

    @Override
    public Bin get(Integer bin) {
        Connection con = sql2o.open();
        sql2o.setDefaultColumnMappings(Sql2OUtil.getColumnMapping(new Bin()));
        return con.createQuery("SELECT * FROM BIN WHERE BIN = :binParam")
                .addParameter("binParam", bin)
                .executeAndFetchFirst(Bin.class);
    }
}
