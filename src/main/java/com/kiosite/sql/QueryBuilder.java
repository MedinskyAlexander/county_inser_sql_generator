package com.kiosite.sql;

import com.kiosite.model.County;

import static java.lang.String.format;

/**
 * Created by alexmedinsky on 07.07.17.
 */
public class QueryBuilder {

    private final String SqlTemplate = "INSERT INTO background.county_lookup(zipcode, state, city, county) " +
            "SELECT '%s','%s','%s','%s' " +
            "WHERE NOT EXISTS (SELECT * FROM background.county_lookup WHERE zipcode='%s');";

    public String buildSQL(County county) {
        String city = county.getUnacceptableCity();
        if (city.isEmpty()){
            city = county.getAcceptableCity();
            if (city.isEmpty()){
                city = county.getPrimaryCity();
            }
        }
        return format(SqlTemplate, county.getZipcode(), county.getState(), city, county.getCounty(), county.getZipcode());
    }

}
