package com.kiosite.sql;

import com.kiosite.model.County;

import java.util.List;

import static java.lang.String.format;

/**
 * Created by alexmedinsky on 07.07.17.
 */
public class QueryBuilder {

    private final String SqlTemplate = "INSERT INTO background.county_lookup(zipcode, state, city, county) " +
            "('%s','%s','%s','%s');";

    public String buildSQL(List<County> counties) {
        StringBuilder sb = new StringBuilder();
        counties.forEach(c -> {
            sb.append(buildSQL(c));
            sb.append("\n");
        });
        return sb.toString();
    }

    private String buildSQL(County county) {
        String city = county.getUnacceptableCity();
        if (city.isEmpty()){
            city = county.getAcceptableCity();
            if (city.isEmpty()){
                city = county.getPrimaryCity();
            }
        }
        return format(SqlTemplate, county.getZipcode(), county.getState(), city, county.getCounty());
    }

}
