package com.kiosite;

import com.kiosite.dao.CountyDAO;
import com.kiosite.model.County;
import com.kiosite.orm.HibernateUtil;
import com.kiosite.reader.CsvReader;
import com.kiosite.sql.QueryBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String CSV_FILE_PATH = "/zip_code_database.csv";
    private static final String OUTPUT_FILE_PATH = "/home/alexmedinsky/Documents/hiretrue/tasks/45/query/";
    private static final String OUTPUT_FILE_NAME_TEMPLATE = "county_insert_if_not_exist_%d.sql";


    public static void main(String[] args) throws IOException {

        List<County> rows = new CsvReader(CSV_FILE_PATH).readFile().getRows();

        CountyDAO countyDao = new CountyDAO();
        List<County> persistedCounties = countyDao.findAllCounties();
        HibernateUtil.shutdown();

        List<County> newCounties = rows.stream()
                .filter(row -> !persistedCounties.contains(row))
                .collect(Collectors.toList());


        QueryBuilder queryBuilder = new QueryBuilder();
        StringBuilder sb = new StringBuilder();

        for (County county : newCounties) {
            sb.append(queryBuilder.buildSQL(county));
            sb.append("\n");
        }
        saveFile(String.format(OUTPUT_FILE_NAME_TEMPLATE, 0), sb.toString());

        System.out.println(sb.toString());
    }

    private static void saveFile(String fileName, String content) {
        try{
            Files.write(Paths.get(OUTPUT_FILE_PATH, fileName), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
