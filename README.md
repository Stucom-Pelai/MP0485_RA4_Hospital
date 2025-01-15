# Hospital Management Program

## Description
This Java program helps manage and analyze patient data in a hospital. It allows input of patient details such as name, weight, and height, calculates their Body Mass Index (BMI or IMC), and provides various management options through a menu-driven interface.

---

## Features
1. Input patient data (name, weight, height).
2. Calculate BMI for all patients.
3. Display options:
   - Show all patients with their BMI.
   - Identify the patient with the highest BMI.
   - Filter and list patients taller than a specified height.
   - Check if the patient with the lowest BMI is also the shortest.
4. Exit the program.

---

## Prerequisites
- **Java JDK 8 or higher**: Ensure you have Java installed on your system to compile and run the program.
- **IDE or Command Line**: You can use an IDE like IntelliJ IDEA, Eclipse, or the command line to execute the code.

---

## How to Use
1. Clone or download the project.
2. Open the program in your preferred Java editor or command line.
3. Compile the program:
   ```bash
   javac Hospital.java

## Notes
- The BMI is calculated using the formula:
![image](https://github.com/user-attachments/assets/b173e3a7-8fa5-46bd-adfe-c362f6b92440)
- No validation for invalid input (e.g., negative values or non-numeric data).
- Case 4 logic assumes no duplicate lowest BMI or shortest height scenarios.
