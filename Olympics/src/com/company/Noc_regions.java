package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Noc_regions {

    List<Noc_regions> noc_Data = new ArrayList<>();

    String noc, region, notes;

    Noc_regions(String noc, String region, String notes) {
        this.noc = noc;
        this.region = region;
        this.notes = notes;
    }

    public Noc_regions() {

    }

    private static Noc_regions createNoc(String[] data) {
        String noc = data[0];
        String region = data[1];
        String notes;
        if (data.length == 3)
            notes = data[2];
        else
            notes = null;
        return (new Noc_regions(noc, region, notes));
    }

    public void readAtOnce(String file) {
        try (BufferedReader bufferreader = Files.newBufferedReader(Paths.get(file), StandardCharsets.US_ASCII)) {

            String line = bufferreader.readLine();
            line = bufferreader.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Noc_regions noc_regions = createNoc(attributes);
                noc_Data.add(noc_regions);
                line = bufferreader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}


