package com.emreuzun.bank.core.service.bin;

import com.emreuzun.bank.core.dao.GenericDao;
import com.emreuzun.bank.core.dao.bin.BinDao;
import com.emreuzun.bank.core.model.Bin;
import com.emreuzun.bank.core.util.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BinServiceImpl implements BinService {

    @Autowired
    private BinDao binDao;

    @Autowired
    private GenericDao genericDao;

    @Autowired
    private PropertyService propertyService;

    @PostConstruct
    public void init() {
        if (propertyService.isDevelopmentMode()) {
            genericDao.createQuery("CREATE TABLE BIN (ISSUER_ID BIGINT ,BIN INT,BIN_START INT,BIN_END INT)");
        }
    }

    @Override
    public void save(Bin bin) {
        binDao.save(bin);
    }

    @Override
    public Bin get(Integer bin) {
        return binDao.get(bin);
    }
}
