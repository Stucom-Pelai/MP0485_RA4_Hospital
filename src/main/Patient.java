package main;

import java.util.Random;

public class Patient {
    private String name;
    private double weight;
    private int height;
    private boolean hospitalized;
    private double imc;
    private Room room; // Each patient is assigned a room

    public Patient(String name, double weight, int height, Room room) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hospitalized = true;
        this.room = room;
        this.imc = calculateIMC();
    }

    private double calculateIMC() {
        double heightMeters = height / 100.0;
        return weight / (heightMeters * heightMeters);
    }

    public String getName() {
        return name;
    }

    public double getIMC() {
        return imc;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHospitalized() {
        return hospitalized;
    }

    public void discharge() {
        this.hospitalized = false;
    }

    public void printPatientInfo() {
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " cm");
        System.out.println("IMC: " + imc);
        System.out.println("Hospitalized: " + (hospitalized ? "Yes" : "No"));
        System.out.println("Room Number: " + room.getNumber() + " (Bath: " + (room.hasBath() ? "Yes" : "No") + ")");
        System.out.println("====================");
    }
}
