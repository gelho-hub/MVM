package MVMContract;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IO {
    private String filename;
    public String getFilename() {
        return filename;
    }
    static Scanner sc = new Scanner(System.in); // input for the whole program
    BufferedReader reader;

    public static void readLinesFromFile(String filename){
        ArrayList<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;

            while((line = br.readLine()) != null){
                String[] parts = line.split(";");
                // lines.add(line);
            }
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

}
