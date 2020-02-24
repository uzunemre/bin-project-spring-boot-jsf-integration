package com.emreuzun.bank.core.dao.bin;

import com.emreuzun.bank.core.model.Bin;

public interface BinDao {

    void save(Bin bin);

    Bin get(Integer bin);

}
