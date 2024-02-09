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
            int sum = 0;

            while ((line = reader.readLine()) != null) {

                String currentSection;
                int sectionNumber = 0;
                // red, green, blue
                int[] highestNumbers = new int[3];

                //Eine Zeile wird getestet
                while (sectionNumber != -1){
                    int[] currentNumbers;
                    try {
                        currentSection = line.substring(sectionNumber, line.indexOf(";", sectionNumber));
                    } catch (Exception e) {
                        break;
                    }
                    sectionNumber = line.indexOf(";", sectionNumber) + 1;
                    // red, green, blue
                    currentNumbers = testPossible(currentSection);
                    for (int i = 0; i < currentNumbers.length; i++){
                        if (currentNumbers[i] > highestNumbers[i]){
                            highestNumbers[i] = currentNumbers[i];
                        }
                    }
                }
                int power = 1;
                for (int highestNumber : highestNumbers) {
                    power *= highestNumber;
                }
                sum += power;
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] testPossible(String line){
        int[] value = new int[3];
        if(line.contains("red")){
            value[0] = getNumber(line, line.indexOf("red"));
        }
        if(line.contains("green")){
            value[1] = getNumber(line, line.indexOf("green"));
        }
        if(line.contains("blue")){
            value[2] = getNumber(line, line.indexOf("blue"));
        }
        return value;
    }

    public int getNumber(String line, int position){

        if(line.charAt(position - 3) == ' '){
            return Character.getNumericValue(line.charAt(position - 2));
        }
        return Integer.parseInt(line.substring(position - 3, position - 1));
    }
}