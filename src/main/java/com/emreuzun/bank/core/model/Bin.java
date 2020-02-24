package com.emreuzun.bank.core.model;


import com.emreuzun.bank.core.annotation.Column;

import java.io.Serializable;

public class Bin implements Serializable {

    @Column(name = "ISSUER_ID")
    private Long issuerId;

    @Column(name = "BIN")
    private Integer bin;

    @Column(name = "BIN_START")
    private Long binStart;

    @Column(name = "BIN_END")
    private Long binEnd;

    public Long getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Long issuerId) {
        this.issuerId = issuerId;
    }

    public Integer getBin() {
        return bin;
    }

    public void setBin(Integer bin) {
        this.bin = bin;
    }

    public Long getBinStart() {
        return binStart;
    }

    public void setBinStart(Long binStart) {
        this.binStart = binStart;
    }

    public Long getBinEnd() {
        return binEnd;
    }

    public void setBinEnd(Long binEnd) {
        this.binEnd = binEnd;
    }
}
