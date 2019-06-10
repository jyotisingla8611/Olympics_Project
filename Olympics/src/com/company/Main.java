package com.company;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.nio.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String athlete_file = "/home/lenovo/MyProjects/Olympics/src/athlete_events.csv";
        Athlete athlete_object = new Athlete();
        athlete_object.readAtOnce(athlete_file);
        System.out.println("Size is athlete_events : "  + athlete_object.athlete_Data.size());

        String noc_file = "/home/lenovo/MyProjects/Olympics/src/noc_regions.csv";
        Noc_regions noc_object = new Noc_regions();
        noc_object.readAtOnce(noc_file);
        System.out.println("Size is noc_regions : "  + noc_object.noc_Data.size());

        OlympicsHostedPerNoc olympicsHostedPerNoc = new OlympicsHostedPerNoc();
        olympicsHostedPerNoc.Outcome(athlete_object.athlete_Data,noc_object.noc_Data);

    }
}
