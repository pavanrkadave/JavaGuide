package oop.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayer {
    public static void main(String[] args) {

        String filePath = "song.wav";
        File file = new File(filePath);


        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file); Scanner scanner = new Scanner(System.in)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            String response = "";

            while (!response.equals("Q")) {
                System.out.print("""
                        
                        ----------------------------------------
                        ---------     Music Player     ---------
                        ----------------------------------------
                         P :- Play
                         S :- Stop
                         R :- Reset
                         Q :- Quit
                        -----------------------------------------
                        
                        """);
                System.out.print("Enter your command: ");
                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid command");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported Audio File : " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("Line Unavailable : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error Opening File : " + e.getMessage());
        } finally {
            System.out.println("""
                    
                    ------------------------
                    -----     Bye!     -----
                    ------------------------
                    
                    """);
        }
    }
}
