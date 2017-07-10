package com.kiosite.model;

import javax.persistence.*;

/**
 * Created by alexmedinsky on 07.07.17.
 */
@Entity
@Table(name = "county_lookup", schema = "background")
public class County {

    @Id
    private int pk;

    private String zipcode;

    @Column(name = "city")
    private String primaryCity;

    @Transient
    private String acceptableCity;

    @Transient
    private String unacceptableCity;

    @Column
    private String state;

    @Column
    private String county;

    public int getPk() {
        return pk;
    }

    public County setPk(int pk) {
        this.pk = pk;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public County setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getPrimaryCity() {
        return primaryCity;
    }

    public County setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
        return this;
    }

    public String getAcceptableCity() {
        return acceptableCity;
    }

    public County setAcceptableCity(String acceptableCity) {
        this.acceptableCity = acceptableCity;
        return this;
    }

    public String getUnacceptableCity() {
        return unacceptableCity;
    }

    public County setUnacceptableCity(String unacceptableCity) {
        this.unacceptableCity = unacceptableCity;
        return this;
    }

    public String getState() {
        return state;
    }

    public County setState(String state) {
        this.state = state;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public County setCounty(String county) {
        this.county = county;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        County county = (County) o;

        return zipcode.equals(county.zipcode);
    }

    @Override
    public int hashCode() {
        return zipcode != null ? zipcode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "County{" +
                "zipcode='" + zipcode + '\'' +
                ", primaryCity='" + primaryCity + '\'' +
                ", acceptableCity='" + acceptableCity + '\'' +
                ", unacceptableCity='" + unacceptableCity + '\'' +
                ", state='" + state + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}
