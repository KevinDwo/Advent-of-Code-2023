import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reading {
    private final int red;
    private final int green;
    private final int blue;

    public Reading() {
        red = 12;
        green = 13;
        blue = 14;
    }
    public void readTextFile(){
        String filePath = "C:/Users/dwork/OneDrive/Persönliche Projekte/Advent of Code 2023/Advent-of-Code-2023/Day 2/Input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentGameNumber = 1;
            int sum = 0;

            while ((line = reader.readLine()) != null) {

                String currentSection;
                boolean possible = true;
                int sectionNumber = 0;

                //Eine Zeile wird getestet
                while (sectionNumber != -1){
                    try {
                        currentSection = line.substring(sectionNumber, line.indexOf(";", sectionNumber));
                    } catch (Exception e) {
                        break;
                    }
                    sectionNumber = line.indexOf(";", sectionNumber + 1);
                    if (!testPossible(currentSection)){
                        possible = false;
                    }
                }


                if (possible){
                    sum += currentGameNumber;
                }

                System.out.println(sum);
                currentGameNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean testPossible(String line){
        if(line.contains("red") && (int) line.charAt(line.indexOf("red") - 2) > red){
            char test = (line.charAt(line.indexOf("red") - 2));
            System.out.println(test + " rot ");
            return false;
        }
        if(line.contains("green") && (int) line.charAt(line.indexOf("green") - 2) > green){
            return false;
        }
        if(line.contains("blue") && (int) line.charAt(line.indexOf("blue") - 2) > blue){
            return false;
        }

        return true;
    }
}