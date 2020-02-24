package com.emreuzun.bank.core.dao.issuer;

import com.emreuzun.bank.core.model.Issuer;
import com.emreuzun.bank.core.model.enumaration.EntityStatusEnum;
import com.emreuzun.bank.core.util.Sql2OUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class IssuerDaoImpl implements IssuerDao {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Issuer> findAll() {
        Connection con = sql2o.open();
        sql2o.setDefaultColumnMappings(Sql2OUtil.getColumnMapping(new Issuer()));
        return con.createQuery("SELECT * FROM ISSUER WHERE STATUS = :statusParam")
                .addParameter("statusParam", EntityStatusEnum.A.name())
                .executeAndFetch(Issuer.class);
    }

    @Override
    public void save(Issuer issuer) {
        String insertSql =
                "insert into ISSUER(id,name,status) " +
                        "values (:idParam, :nameParam, :statusParam)";
        Connection con = sql2o.open();
        con.createQuery(insertSql)
                .addParameter("idParam", issuer.getId())
                .addParameter("nameParam", issuer.getName())
                .addParameter("statusParam", issuer.getStatus())
                .executeUpdate();
    }
}
