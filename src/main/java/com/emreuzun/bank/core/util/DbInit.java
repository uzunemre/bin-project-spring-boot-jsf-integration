package com.emreuzun.bank.core.util;

import com.emreuzun.bank.core.dao.GenericDao;
import com.emreuzun.bank.core.dao.issuer.IssuerDao;
import com.emreuzun.bank.core.model.Issuer;
import com.emreuzun.bank.core.model.enumaration.EntityStatusEnum;
import com.emreuzun.bank.core.service.issuer.IssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    @Autowired
    private GenericDao genericDao;

    @Autowired
    private IssuerDao issuerDao;

    @Autowired
    private PropertyService propertyService;

    @PostConstruct
    public void init() {
        if (propertyService.isDevelopmentMode()) {
            genericDao.createQuery("CREATE TABLE ISSUER (ID IDENTITY NOT NULL, NAME VARCHAR (50) NOT NULL, STATUS VARCHAR (1) NOT NULL)");
            issuerDao.save(new Issuer(15, "Vakıfbank", EntityStatusEnum.A.name()));
            issuerDao.save(new Issuer(46, "Akbank", EntityStatusEnum.A.name()));
            issuerDao.save(new Issuer(64, "İş Bankası", EntityStatusEnum.A.name()));
            issuerDao.save(new Issuer(67, "Yapı Kredi", EntityStatusEnum.A.name()));

            genericDao.createQuery("CREATE TABLE BIN" +
                    "(" +
                    "ISSUER_ID BIGINT not null," +
                    "BIN       INT    not null," +
                    "BIN_START BIGINT not null," +
                    "BIN_END   BIGINT not null," +
                    "CONSTRAINT BIN_PK PRIMARY KEY (BIN)," +
                    "CONSTRAINT BIN_ISSUER_ID_FK FOREIGN KEY (ISSUER_ID) REFERENCES ISSUER (ID)" +
                    ")");
        }
    }

}
