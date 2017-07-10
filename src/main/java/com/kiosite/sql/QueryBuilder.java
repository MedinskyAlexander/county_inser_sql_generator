package com.kiosite.sql;

import com.kiosite.model.Row;

import static java.lang.String.format;

/**
 * Created by alexmedinsky on 07.07.17.
 */
public class QueryBuilder {

    private final String SqlTemplate = "INSERT INTO background.county_lookup(zipcode, state, city, county) " +
            "SELECT '%s','%s','%s','%s' " +
            "WHERE NOT EXISTS (SELECT * FROM background.county_lookup WHERE zipcode='%s');";

    public String buildSQL(Row row){
        String city = row.getUnacceptableCity();
        if (city.isEmpty()){
            city = row.getAcceptableCity();
            if (city.isEmpty()){
                city = row.getPrimaryCity();
            }
        }
        return format(SqlTemplate, row.getZipcode(), row.getState(), city, row.getCounty(), row.getZipcode());
    }

}
