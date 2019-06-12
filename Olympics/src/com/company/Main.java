package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.company.Athlete.*;
import static com.company.NOCRegions.*;

public class Main {

    public static final String NA = "NA";

    static boolean isNA(String str) {
        boolean ans = str.equals(NA);
        return ans;
    }

    public static void extractNocRegionData(String file) {
        try (BufferedReader bufferreader = Files.newBufferedReader(Paths.get(file), StandardCharsets.US_ASCII)) {

            String line = bufferreader.readLine();
            line = bufferreader.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                NOCRegions noc_regions = createNoc(attributes);
                noc_regions.getNocRegions().add(noc_regions);
                line = bufferreader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void extractAthleteData(String file) {
        try (BufferedReader bufferreader = Files.newBufferedReader(Paths.get(file), StandardCharsets.US_ASCII)) {

            String line = bufferreader.readLine();
            line = bufferreader.readLine();
            while (line != null) {

                //(,(?=[^\\)]*(?:\\(|$)))  we can also try to splitt it with this
                String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i] = attributes[i].replace("\"", "");
                }
                Athlete athlete = createAthlete(attributes);
                athlete.getAthletes().add(athlete);
                line = bufferreader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static Athlete createAthlete(String[] data) {

        int id = Integer.parseInt(data[Athlete.ID]);
        String name = data[Athlete.NAME];
        String sex = data[Athlete.SEX];
        boolean ag = isNA(data[AGE]);
        int age = ag ? -1 : Integer.parseInt(data[AGE]);
        boolean hgt = isNA(data[HEIGHT]);
        int height = hgt ? -1 : Integer.parseInt(data[HEIGHT]);
        boolean wt = isNA(data[WEIGHT]);
        double weight = wt ? -1 : Double.parseDouble(data[WEIGHT]);
        String team = data[TEAM];
        String noc = data[NOC];
        String game = data[GAME];
        boolean yr = isNA(data[YEAR]);
        int year = yr ? -1 : Integer.parseInt(data[YEAR]);
        String season = data[SEASON];
        String city = data[CITY];
        String sport = data[SPORT];
        String event = data[EVENT];
        String medal = data[MEDAL];

        return (new Athlete(id, name, sex, age, height, weight, team, noc, game, year, season, city, sport, event, medal));
    }

    private static NOCRegions createNoc(String[] data) {
        String noc = data[NOC_REGION];
        String region = data[REGION];
        String notes;
        if (data.length == NOTES_PRESENCE)
            notes = data[REGION];
        else
            notes = null;
        return (new NOCRegions(noc, region, notes));
    }

    public static void main(String[] args) {
        String athlete_file = "athlete_events.csv";
        String noc_file = "noc_regions.csv";

        extractAthleteData(athlete_file);
        extractNocRegionData(noc_file);


        OlympicsHostedPerNoc.find(Athlete.getAthletes());
        TopMedalist.getResults(Athlete.getAthletes());
        DecadeParticipation.getResults(Athlete.getAthletes());
        BoxingAverage.getResults(Athlete.getAthletes());
        MedalWinners.getResults(Athlete.getAthletes());
    }
}
