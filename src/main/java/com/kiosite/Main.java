package com.kiosite;

import com.kiosite.model.Row;
import com.kiosite.reader.CsvReader;
import com.kiosite.sql.QueryBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH = "/zip_code_database.csv";
    private static final String OUTPUT_FILE_PATH = "/home/alexmedinsky/Documents/hiretrue/tasks/45/query/";
    private static final String OUTPUT_FILE_NAME_TEMPLATE = "county_insert_if_not_exist_%d.sql";


    public static void main(String[] args) throws IOException {

        List<Row> rows = new CsvReader(CSV_FILE_PATH).readFile().getRows();
        QueryBuilder queryBuilder = new QueryBuilder();
        StringBuilder sb = new StringBuilder();

        int fileCounter = 0;

        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            sb.append(queryBuilder.buildSQL(row));
            sb.append("\n");
            if (i > 0 && i % 1000 == 0) {
                saveFile(String.format(OUTPUT_FILE_NAME_TEMPLATE, fileCounter++), sb.toString());
                sb.delete(0, sb.length());
            }
        }

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
