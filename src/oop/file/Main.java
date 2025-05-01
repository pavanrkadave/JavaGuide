package oop.file;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        String filePath = "test.txt";
        String content = """
                
                ----------------------------------------
                Hello World!
                This is a test file.
                Goodbye World!
                ----------------------------------------
                """;

        writeToFile(filePath, content);
        readFromFile(filePath);
    }

    /**
     *
     * File Writer      =    Good for small to medium text files
     * BufferedWriter   =    Good for large text files
     * PrintWriter      =    Good for structured data like CSV, XML, etc.
     * FileOutputStream =    Good for binary files like images, audio, etc.
     *
     * @param filePath is the path to the file to write to.
     * @param content is the String content to write to the file.
     */
    private static void writeToFile(String filePath, String content) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
    }

    /**
     *
     * BufferedReader + FileReader = Best for reading text files line-by-line
     * FileInputStream             = Best for binary files (e.g., images, audio files)
     * RandomAccessFile            = Best for read/write specific portions of a large file
     *
     * @param filePath is the path to the file to read the content from
     */
    private static void readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
            String line;
            System.out.println("Reading from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not read from file: " + e.getMessage());
        }
    }
}
