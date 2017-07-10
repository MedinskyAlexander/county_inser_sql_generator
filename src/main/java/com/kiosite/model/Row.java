package com.kiosite.model;

/**
 * Created by alexmedinsky on 07.07.17.
 */
public class Row {

    private String zipcode;
    private String primaryCity;
    private String acceptableCity;
    private String unacceptableCity;
    private String state;
    private String county;

    public String getZipcode() {
        return zipcode;
    }

    public Row setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getPrimaryCity() {
        return primaryCity;
    }

    public Row setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
        return this;
    }

    public String getAcceptableCity() {
        return acceptableCity;
    }

    public Row setAcceptableCity(String acceptableCity) {
        this.acceptableCity = acceptableCity;
        return this;
    }

    public String getUnacceptableCity() {
        return unacceptableCity;
    }

    public Row setUnacceptableCity(String unacceptableCity) {
        this.unacceptableCity = unacceptableCity;
        return this;
    }

    public String getState() {
        return state;
    }

    public Row setState(String state) {
        this.state = state;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public Row setCounty(String county) {
        this.county = county;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Row row = (Row) o;

        if (zipcode != null ? !zipcode.equals(row.zipcode) : row.zipcode != null) return false;
        if (primaryCity != null ? !primaryCity.equals(row.primaryCity) : row.primaryCity != null) return false;
        if (acceptableCity != null ? !acceptableCity.equals(row.acceptableCity) : row.acceptableCity != null)
            return false;
        if (unacceptableCity != null ? !unacceptableCity.equals(row.unacceptableCity) : row.unacceptableCity != null)
            return false;
        if (state != null ? !state.equals(row.state) : row.state != null) return false;
        return county != null ? county.equals(row.county) : row.county == null;
    }

    @Override
    public int hashCode() {
        int result = zipcode != null ? zipcode.hashCode() : 0;
        result = 31 * result + (primaryCity != null ? primaryCity.hashCode() : 0);
        result = 31 * result + (acceptableCity != null ? acceptableCity.hashCode() : 0);
        result = 31 * result + (unacceptableCity != null ? unacceptableCity.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Row{" +
                "zipcode='" + zipcode + '\'' +
                ", primaryCity='" + primaryCity + '\'' +
                ", acceptableCity='" + acceptableCity + '\'' +
                ", unacceptableCity='" + unacceptableCity + '\'' +
                ", state='" + state + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}
