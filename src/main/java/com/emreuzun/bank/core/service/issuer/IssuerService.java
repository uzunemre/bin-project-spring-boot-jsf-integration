package com.emreuzun.bank.core.service.issuer;

import com.emreuzun.bank.core.model.Issuer;

import java.util.List;

public interface IssuerService {

    List<Issuer> findAllOrderByNameAsc();

    void save(Issuer issuer);
}
