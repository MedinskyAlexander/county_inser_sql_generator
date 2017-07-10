package com.kiosite.reader;

import com.kiosite.model.Row;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alexmedinsky on 07.07.17.
 */
public class CsvReader {


    private String pathToFile;
    private List<Row> rows = new ArrayList<>();

    public CsvReader(String path) {
        pathToFile = path;
    }

    public List<Row> getRows() {
        return rows;
    }

    public CsvReader readFile(){
        String pathToFile = getClass().getResource(this.pathToFile).getFile();
        try(Scanner scanner = new Scanner(new File(pathToFile))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] elements = line.split("\t");

                if (elements.length == 6) {
                    Row row = new Row()
                            .setZipcode(fixQuotes(elements[0]))
                            .setPrimaryCity(fixQuotes(elements[1]))
                            .setAcceptableCity(fixQuotes(elements[2]))
                            .setUnacceptableCity(fixQuotes(elements[3]))
                            .setState(fixQuotes(elements[4]))
                            .setCounty(fixQuotes(elements[5]));

                    rows.add(row);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }


    private String fixQuotes(String line){
        return line.replace("\"", "");
    }

}
