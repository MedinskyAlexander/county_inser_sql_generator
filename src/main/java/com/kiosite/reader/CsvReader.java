package com.kiosite.reader;

import com.kiosite.model.County;

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
    private List<County> rows = new ArrayList<>();

    public CsvReader(String path) {
        pathToFile = path;
    }

    public List<County> getRows() {
        return rows;
    }

    public CsvReader readFile(){
        String pathToFile = getClass().getResource(this.pathToFile).getFile();
        try(Scanner scanner = new Scanner(new File(pathToFile))) {
            scanner.nextLine();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] elements = line.split("\t");

                try {
                    County county = new County()
                            .setZipcode(fixQuotes(elements[0]))
                            .setPrimaryCity(fixQuotes(elements[1]))
                            .setAcceptableCity(fixQuotes(elements[2]))
                            .setUnacceptableCity(fixQuotes(elements[3]))
                            .setState(fixQuotes(elements[4]))
                            .setCounty(fixCounty(fixQuotes(elements[5])));

                    rows.add(county);
                } catch (Exception e) {
                    System.out.println("Oops, bad row: " + line);
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

    private String fixCounty(String line) {
        String result = line.replace("County", "");
        return result.trim();
    }

}
