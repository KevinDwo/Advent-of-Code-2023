import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reading {
    public Reading() {
    }
    public void readTextFile(){
        String filePath = "C:/Users/dwork/OneDrive/Persönliche Projekte/Advent of Code 2023/Advent-of-Code-2023/Day 2/Input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}