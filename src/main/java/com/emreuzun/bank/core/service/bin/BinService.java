package com.emreuzun.bank.core.service.bin;

import com.emreuzun.bank.core.model.Bin;


public interface BinService {

    void save(Bin bin);

    Bin get(Integer bin);
}
