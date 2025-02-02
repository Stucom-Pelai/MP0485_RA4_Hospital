package main;

import java.util.Random;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("How many patients?");
        int numberPatients = sc.nextInt();
        sc.nextLine();

        Patient[] patients = new Patient[numberPatients];

        for (int i = 0; i < numberPatients; i++) {
            System.out.println("Enter name:");
            String name = sc.nextLine();

            System.out.println("Enter weight (kg):");
            double weight = sc.nextDouble();

            System.out.println("Enter height (cm):");
            int height = sc.nextInt();
            sc.nextLine(); // Consume newline

            Room assignedRoom = new Room(rand.nextInt(100) + 1); // Assign a random room number (1-100)
            patients[i] = new Patient(name, weight, height, assignedRoom);
        }

        int option;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Show all patients with IMC");
            System.out.println("2. Show patient with highest IMC");
            System.out.println("3. Show patients taller than a given height");
            System.out.println("4. Check if lowest IMC patient is the shortest one");
            System.out.println("5. Discharge a patient");
            System.out.println("6. Exit program");

            option = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    for (Patient p : patients) {
                        p.printPatientInfo();
                    }
                    break;

                case 2:
                    Patient maxIMC = patients[0];
                    for (Patient p : patients) {
                        if (p.getIMC() > maxIMC.getIMC()) {
                            maxIMC = p;
                        }
                    }
                    System.out.println("Patient with highest IMC: " + maxIMC.getName() + " (" + maxIMC.getIMC() + ")");
                    break;

                case 3:
                    System.out.println("Enter height threshold (cm):");
                    int heightCriteria = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Patients taller than " + heightCriteria + " cm:");
                    for (Patient p : patients) {
                        if (p.getHeight() > heightCriteria) {
                            System.out.println(p.getName());
                        }
                    }
                    break;

                case 4:
                    Patient minIMC = patients[0];
                    Patient shortest = patients[0];

                    for (Patient p : patients) {
                        if (p.getIMC() < minIMC.getIMC()) {
                            minIMC = p;
                        }
                        if (p.getHeight() < shortest.getHeight()) {
                            shortest = p;
                        }
                    }

                    if (minIMC == shortest) {
                        System.out.println("The patient with the lowest IMC is also the shortest.");
                    } else {
                        System.out.println("The shortest patient is NOT the one with the lowest IMC.");
                    }
                    break;

                case 5:
                    System.out.println("Enter the name of the patient to discharge:");
                    String dischargeName = sc.nextLine();
                    boolean found = false;

                    for (Patient p : patients) {
                        if (p.getName().equalsIgnoreCase(dischargeName)) {
                            if (!p.isHospitalized()) {
                                System.out.println(dischargeName + " is already discharged.");
                            } else {
                                p.discharge();
                                System.out.println(dischargeName + " has been discharged.");
                            }
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 6:
                    System.out.println("Goodbye, doctor!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 6);

        sc.close();
    }
}
