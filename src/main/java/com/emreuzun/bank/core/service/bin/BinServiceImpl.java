package com.emreuzun.bank.core.service.bin;

import com.emreuzun.bank.core.dao.bin.BinDao;
import com.emreuzun.bank.core.model.Bin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinServiceImpl implements BinService {

    @Autowired
    private BinDao binDao;

    @Override
    public void save(Bin bin) {
        binDao.save(bin);
    }

    @Override
    public Bin get(Integer bin) {
        return binDao.get(bin);
    }
}
