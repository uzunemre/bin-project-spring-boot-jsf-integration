package com.emreuzun.bank.web.support;

import com.emreuzun.bank.core.model.Bin;
import com.emreuzun.bank.core.model.Issuer;
import com.emreuzun.bank.core.service.bin.BinService;
import com.emreuzun.bank.core.service.issuer.IssuerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class BinAddSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private IssuerService issuerService;

    @Autowired
    private BinService binService;

    private List<Issuer> issuerList;

    private Bin instance;

    private Issuer selectedIssuer;

    private Integer binNumber;

    private boolean inserted = false;

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            instance = new Bin();
            issuerList = issuerService.findAllOrderByNameAsc();
        }
    }

    public void save() throws IOException {
        try {
            Bin bin = binService.get(instance.getBin());
            if (bin == null) {
                instance.setIssuerId(selectedIssuer.getId());
                binService.save(instance);
                inserted = true;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "", "Yaptığınız işlem başarıyla gerçekleştirilmiştir"));
            } else {
                // todo messages properties
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "", "Girdiğiniz değer sistemde önceden tanımlanmıştır."));
            }
        } catch (Exception e) {
            // todo log
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "", e.getMessage()));
        }

    }

    public void binListener() {
        binNumber = instance.getBin();
    }

    public List<Issuer> getIssuerList() {
        return issuerList;
    }

    public Bin getInstance() {
        return instance;
    }

    public Integer getBinNumber() {
        return binNumber;
    }

    public void setSelectedIssuer(Issuer selectedIssuer) {
        this.selectedIssuer = selectedIssuer;
    }

    public Issuer getSelectedIssuer() {
        return selectedIssuer;
    }

    public boolean isInserted() {
        return inserted;
    }
}
