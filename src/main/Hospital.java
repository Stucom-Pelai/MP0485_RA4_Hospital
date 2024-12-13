package main;

import java.util.Arrays;
import java.util.Scanner;

public class Hospital {

    public static void main(String[] args) {
        // INPUT
        //=====================================================================================
        // fill data patient

        // define number of patient
        Scanner sc = new Scanner(System.in);
        System.out.println("how many patients?");
        int numberPatients = sc.nextInt();
        sc.nextLine();
        String[] names = new String[numberPatients];
        double[] weights = new double[numberPatients];
        int[] heights = new int[numberPatients];

        // introduce data for each patient
        String name;
        double weight;
        int height;
        for (int i = 0; i < numberPatients; i++) {
            System.out.println("which name?");
            name = sc.nextLine();
            names[i] = name;
            System.out.println("which weight?");
            weight = sc.nextDouble();
            sc.nextLine();
            weights[i] = weight;
            System.out.println("which height?");
            height = sc.nextInt();
            sc.nextLine();
            heights[i] = height;
        }

        // calculate imc for all patients
        double[] imcs = new double[numberPatients];
        for (int i = 0; i < numberPatients; i++) {
            double height2 = ((double) heights[i] / 100) * ((double) heights[i] / 100);

            imcs[i] = (double) weights[i] / height2;
        }

        // BUSINESS LOGIC + OUTPUT
        //=====================================================================================
        // management menu
        int option = 0;
        do {
            System.out.println("Choose option:");
            System.out.println("1. Show all patients with IMC:");
            System.out.println("2. Show patient with highest IMC:");
            System.out.println("3. Show patients with heigth more than ...:");
            System.out.println("4. Check if lowest IMC patient is the shortest one ...:");
            System.out.println("5. Exit program:");

            option = sc.nextInt();
            switch (option) {
                case 1:
                    //show all patients with IMC
                    double imc = 0.0;
                    for (int i = 0; i < numberPatients; i++) {
                        System.out.println("name is: " + names[i]);
                        System.out.println("weight is: " + weights[i]);
                        System.out.println("height is: " + weights[i]);
                        System.out.println("imc is: " + imcs[i]);
                        System.out.println("====================");

                    }
                    break;

                case 2:
                    //show patient with highest IMC
                    double imcMax = 0.0;
                    int indexImcMax = 0;
                    for (int i = 0; i < numberPatients; i++) {
                        if (imcs[i] > imcMax) {
                            imcMax = imcs[i];
                            indexImcMax = i;
                        }
                    }
                    System.out.println("patient with highest IMC is " + names[indexImcMax] + " with " + imcs[indexImcMax]);

                case 3:
                    //filter by height
                    int heightCriteria = 0;
                    System.out.println("filter height?");
                    heightCriteria = sc.nextInt();
                    sc.nextLine();
                    System.out.println("patients taller than input height");
                    for (int i = 0; i < numberPatients; i++) {
                        if (heights[i] > heightCriteria);
                        {
                            System.out.println(names[i]);
                        }
                    }
                    break;

                case 4:
                    //check patient with lowest IMC and smallest is the same one
                    // get lowest IMC
                    double imcMin = 1000.0;
                    int indexImcMin = 0;
                    for (int i = 0; i < numberPatients; i++) {
                        if (imcs[i] < imcMin) {
                            imcMin = imcs[i];
                            indexImcMin = i;
                        }
                    }

                    // get smallest
                    double heightMin = 1000;
                    int indexShortest = 0;
                    for (int i = 0; i < numberPatients; i++) {
                        if (heights[i] < heightMin) {
                            heightMin = heights[i];
                            indexShortest = i;
                        }
                    }

                    // compare if same patient
                    if (!names[indexImcMin].equals(names[indexShortest])) {
                        System.out.println("shortest patient is the lowest IMC");
                    } else {
                        System.out.println("shortest patient is NOT the lowest IMC");
                    }
                    break;

                case 5:
                    //exit application
                    break;

                default:
                    break;
            }

        } while (option != 5);
        System.out.println("goodbye doctor");
    }

}
