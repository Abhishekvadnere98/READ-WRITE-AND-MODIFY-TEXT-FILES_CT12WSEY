JAVA INTERNSHIP TASK DOCUMENTATION
Task Name:
Create a Java Program to Read, Write, and Modify Text Files

Intern Details:
Intern Name: Abhishek Vadnere

Intern ID: CT12WSEY

Company Name: CODTECH IT SOLUTIONS

Technology Used: Java (Core Java - File Handling)

1. Introduction
File handling is an essential part of any programming language, allowing programs to interact with files stored on a system. In Java, file handling is achieved using built-in classes such as File, FileReader, FileWriter, and BufferedReader. The objective of this task is to develop a Java program that performs the following operations on a text file:

Reading a text file – Retrieve and display the content from a file.

Writing to a text file – Create or overwrite a file with new content.

Modifying a text file – Append new content or update existing content in the file.

This document provides a comprehensive explanation of the implementation, including the logic, methodologies, and key functions used in Java to achieve the task.

2. Objectives of the Task
Learn and implement Java's file handling operations.

Understand reading and writing operations using FileReader and FileWriter.

Modify existing file content using Java.

Use exception handling to manage file operations efficiently.

Demonstrate a structured and modular approach to Java programming.

3. Prerequisites
Before implementing this task, it is essential to have:

Basic knowledge of Java programming.

Understanding of Java’s IO (Input/Output) package.

Java Development Kit (JDK) installed.

A Java IDE such as Eclipse, IntelliJ IDEA, or VS Code.

4. Tools and Technologies Used
Programming Language: Java (JDK 1.8 or above)

IDE Used: Eclipse/IntelliJ IDEA

Operating System: Windows/Linux/MacOS

Concepts Implemented: File Handling, Exception Handling, Buffered Streams

5. Implementation Approach
The program is implemented in three phases:

Phase 1: Reading from a Text File
Use the FileReader and BufferedReader classes to read a text file.

Display the contents on the console.

Phase 2: Writing to a Text File
Use the FileWriter class to write data into a text file.

Handle file overwriting scenarios.

Phase 3: Modifying a Text File
Use FileWriter in append mode or read the file, modify its contents, and rewrite it.

Implement exception handling to ensure safe file operations.

6. Implementation Code
java
Copy
Edit
import java.io.*;

public class FileHandlingExample {

    // Method to read a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading File: " + fileName);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to write to a file
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Successfully written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to modify (append to) a file
    public static void modifyFile(String fileName, String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine(); // Adds a new line before appending
            writer.write(newContent);
            System.out.println("Successfully modified (appended) file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "example.txt";
        String initialContent = "Hello, this is a Java file handling example.";
        String modifiedContent = "This is additional content appended to the file.";

        // Writing to file
        writeFile(fileName, initialContent);
        
        // Reading from file
        readFile(fileName);
        
        // Modifying (Appending) file
        modifyFile(fileName, modifiedContent);

        // Reading again to check modifications
        readFile(fileName);
    }
}
