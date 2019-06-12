package com.company;
public class Main {

    public static void main(String[] args) {
        String athlete_file = "/home/lenovo/MyProjects/Olympics/src/athlete_events.csv";
        String noc_file = "/home/lenovo/MyProjects/Olympics/src/noc_regions.csv";

        Athlete athlete_object = new Athlete();
        Noc_regions noc_object = new Noc_regions();

        athlete_object.readAtOnce(athlete_file);
        noc_object.readAtOnce(noc_file);

        OlympicsHostedPerNoc olympicsHostedPerNoc = new OlympicsHostedPerNoc();
        MedalWinners medalWinners  = new MedalWinners();
        BoxingAverage boxingAverage = new BoxingAverage();
        DecadeParticipation decadeParticipation = new DecadeParticipation();
        TopMedalist topMedalist = new TopMedalist();

        olympicsHostedPerNoc.Outcome(athlete_object.athlete_Data);
        medalWinners.getResults(athlete_object.athlete_Data);
        boxingAverage.getResults(athlete_object.athlete_Data);
        decadeParticipation.getResults(athlete_object.athlete_Data);
        topMedalist.getResults(athlete_object.athlete_Data);
    }
}
