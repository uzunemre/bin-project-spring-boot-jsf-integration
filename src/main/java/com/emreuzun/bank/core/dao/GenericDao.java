package com.emreuzun.bank.core.dao;

import java.io.Serializable;

public interface GenericDao extends Serializable {
    void createQuery(String query);
}
