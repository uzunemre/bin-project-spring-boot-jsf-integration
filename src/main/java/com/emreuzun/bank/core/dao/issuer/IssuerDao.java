package com.emreuzun.bank.core.dao.issuer;

import com.emreuzun.bank.core.model.Issuer;

import java.util.List;

public interface IssuerDao {

    List<Issuer> findAll();

    void save(Issuer issuer);

}
