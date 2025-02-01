package main;

import java.util.Scanner;

public class Hospital {

    public static void main(String[] args) {
        // INPUT
        //=====================================================================================
        // Define number of patients
        Scanner sc = new Scanner(System.in);
        System.out.println("How many patients?");
        int numberPatients = sc.nextInt();
        sc.nextLine();

        // Arrays to store patient data
        String[] names = new String[numberPatients];
        double[] weights = new double[numberPatients];
        int[] heights = new int[numberPatients];
        boolean[] hospitalized = new boolean[numberPatients];  // New attribute

        // Fill data for each patient
        for (int i = 0; i < numberPatients; i++) {
            System.out.println("Enter name:");
            names[i] = sc.nextLine();

            System.out.println("Enter weight (kg):");
            weights[i] = sc.nextDouble();

            System.out.println("Enter height (cm):");
            heights[i] = sc.nextInt();
            sc.nextLine(); // Consume newline

            hospitalized[i] = true; // Default value
        }

        // Calculate IMC for all patients
        double[] imcs = new double[numberPatients];
        for (int i = 0; i < numberPatients; i++) {
            double heightMeters = heights[i] / 100.0;
            imcs[i] = weights[i] / (heightMeters * heightMeters);
        }

        // BUSINESS LOGIC + OUTPUT
        //=====================================================================================
        int option;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Show all patients with IMC");
            System.out.println("2. Show patient with highest IMC");
            System.out.println("3. Show patients taller than a given height");
            System.out.println("4. Check if lowest IMC patient is the shortest one");
            System.out.println("6. Discharge a patient");  // Moved above option 5
            System.out.println("5. Exit program");

            option = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Show all patients with IMC
                    for (int i = 0; i < numberPatients; i++) {
                        System.out.println("Name: " + names[i]);
                        System.out.println("Weight: " + weights[i] + " kg");
                        System.out.println("Height: " + heights[i] + " cm");
                        System.out.println("IMC: " + imcs[i]);
                        System.out.println("Hospitalized: " + (hospitalized[i] ? "Yes" : "No"));
                        System.out.println("====================");
                    }
                    break;

                case 2:
                    // Show patient with highest IMC
                    double imcMax = imcs[0];
                    int indexImcMax = 0;
                    for (int i = 1; i < numberPatients; i++) {
                        if (imcs[i] > imcMax) {
                            imcMax = imcs[i];
                            indexImcMax = i;
                        }
                    }
                    System.out.println("Patient with highest IMC: " + names[indexImcMax] + " (" + imcs[indexImcMax] + ")");
                    break;

                case 3:
                    // Show patients taller than a given height
                    System.out.println("Enter height threshold (cm):");
                    int heightCriteria = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Patients taller than " + heightCriteria + " cm:");
                    for (int i = 0; i < numberPatients; i++) {
                        if (heights[i] > heightCriteria) {
                            System.out.println(names[i]);
                        }
                    }
                    break;

                case 4:
                    // Check if lowest IMC patient is also the shortest one
                    int indexImcMin = 0;
                    for (int i = 1; i < numberPatients; i++) {
                        if (imcs[i] < imcs[indexImcMin]) {
                            indexImcMin = i;
                        }
                    }

                    int indexShortest = 0;
                    for (int i = 1; i < numberPatients; i++) {
                        if (heights[i] < heights[indexShortest]) {
                            indexShortest = i;
                        }
                    }

                    if (indexImcMin == indexShortest) {
                        System.out.println("The patient with the lowest IMC is also the shortest.");
                    } else {
                        System.out.println("The shortest patient is NOT the one with the lowest IMC.");
                    }
                    break;

                case 6:  // Discharge a patient (moved above option 5)
                    System.out.println("Enter the name of the patient to discharge:");
                    String dischargeName = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < numberPatients; i++) {
                        if (names[i].equalsIgnoreCase(dischargeName)) {
                            if (!hospitalized[i]) {
                                System.out.println(dischargeName + " is already discharged.");
                            } else {
                                hospitalized[i] = false;
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

                case 5:
                    // Exit program
                    System.out.println("Goodbye, doctor!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 5);

        sc.close();
    }
}
