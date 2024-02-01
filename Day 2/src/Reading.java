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
                    sectionNumber = line.indexOf(";", sectionNumber) + 1;
                    if (!testPossible(currentSection)){
                        possible = false;
                        break;
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
        int value;
        if(line.contains("red")){
            value = getNumber(line, line.indexOf("red"));
            if(value > red){
                return false;
            }
        }
        if(line.contains("blue")){
            value = getNumber(line, line.indexOf("blue"));
            if(value > blue){
                return false;
            }
        }
        if(line.contains("green")){
            value = getNumber(line, line.indexOf("green"));
            if(value > green){
                return false;
            }
        }
        return true;
    }

    public int getNumber(String line, int position){

        if(line.charAt(position - 3) == ' '){
            return Character.getNumericValue(line.charAt(position - 2));
        }
        return Integer.parseInt(line.substring(position - 3, position - 1));
    }
}