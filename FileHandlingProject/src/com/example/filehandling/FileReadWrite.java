package com.example.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWrite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the input file path
        System.out.print("Enter the path to the input file: ");
        String inputFilePath = scanner.nextLine();

        // Ask the user for the output file path
        System.out.print("Enter the path to the output file: ");
        String outputFilePath = scanner.nextLine();

        // Ask the user for content to write to the output file
        System.out.print("Enter the content to write to the output file: ");
        String contentToWrite = scanner.nextLine();

        // Ask the user for content to append to the output file
        System.out.print("Enter the content to append to the output file: ");
        String contentToAppend = scanner.nextLine();

        // Close the scanner
        scanner.close();

        // Read from the input file
        System.out.println("Reading from file...");
        readFile(inputFilePath);

        // Write to the output file
        System.out.println("Writing to file...");
        writeFile(outputFilePath, contentToWrite);

        // Modify (append) the output file
        System.out.println("Modifying file (appending)...");
        modifyFile(outputFilePath, contentToAppend);
    }

    // Method to read a file
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to write to a file
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to modify a file 
    public static void modifyFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("\n" + content); // Add a newline before appending
            System.out.println("Content appended to file successfully.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
}