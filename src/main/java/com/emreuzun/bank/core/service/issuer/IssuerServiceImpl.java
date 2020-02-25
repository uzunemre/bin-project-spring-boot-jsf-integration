package com.emreuzun.bank.core.service.issuer;

import com.emreuzun.bank.core.dao.GenericDao;
import com.emreuzun.bank.core.dao.issuer.IssuerDao;
import com.emreuzun.bank.core.model.Issuer;
import com.emreuzun.bank.core.model.enumaration.EntityStatusEnum;
import com.emreuzun.bank.core.util.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class IssuerServiceImpl implements IssuerService {

    @Autowired
    private IssuerDao issuerDao;

    @Override
    public List<Issuer> findAllOrderByNameAsc() {
        return issuerDao.findAll()
                .stream()
                .sorted(Comparator.comparing(Issuer::getName, Collator.getInstance(new Locale("tr", "TR"))))
                .collect(Collectors.toList());
        /*List<Issuer> issuerList = new ArrayList<>();
        issuerList.add(new Issuer(15, "Vakıfbank", EntityStatusEnum.A.name()));
        issuerList.add(new Issuer(46, "Akbank", EntityStatusEnum.A.name()));
        issuerList.add(new Issuer(64, "İş Bankası", EntityStatusEnum.A.name()));
        issuerList.add(new Issuer(67, "Yapı Kredi", EntityStatusEnum.A.name()));
        return issuerList;*/
    }

    @Override
    public void save(Issuer issuer) {
        issuerDao.save(issuer);
    }
}
