package com.kee.isocurrencycoderestapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "iso_currency_code")
public class IsoCurrencyCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "alphabetic_code")
    private String alphabeticCode;

    @Column(name = "entity")
    private String entity;

    @Column(name = "currency")
    private String currency;

    @Column(name = "numeric_code")
    private String numericCode;

    @Column(name = "minor_unit")
    private int minorUnit;

    public IsoCurrencyCode() {}

    public IsoCurrencyCode(String entity, String currency, String alphabeticCode, String numericCode, int minorUnit) {
        super();
        this.entity = entity;
        this.currency = currency;
        this.alphabeticCode = alphabeticCode;
        this.numericCode = numericCode;
        this.minorUnit = minorUnit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAlphabeticCode() {
        return alphabeticCode;
    }

    public void setAlphabeticCode(String alphabeticCode) {
        this.alphabeticCode = alphabeticCode;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public int getMinorUnit() {
        return minorUnit;
    }

    public void setMinorUnit(int minorUnit) {
        this.minorUnit = minorUnit;
    }
}
