/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception{

        ArrayList<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Bush");

        String voteResults = tally(votes);
        System.out.println(voteResults);

        Path gates = Paths.get("src/main/resources/gates.js");
        int errorCount = readBufferTryWithResources(gates.toString());
    }

    public static int readBufferTryWithResources(String filePath) {
        Path path = Paths.get(filePath);
        int errorCount = 0;
        try(BufferedReader reader = Files.newBufferedReader(path)){

            String line = reader.readLine();

            while(line != null){

                if (!line.endsWith(";") &&
                        !line.isEmpty() &&
                        !line.endsWith("{") &&
                        !line.endsWith("}") &&
                        !line.contains("if") &&
                        !line.contains("else")) {
                    System.out.println(line.toString());
                    errorCount++;
                }

                line = reader.readLine();
            }

            if(errorCount != 1){
                System.out.println("Your file contained " + errorCount + " errors.");
            } else {
                System.out.println("Your file contained " + errorCount + " error.");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return errorCount;
    }

    public static String tally(ArrayList<String> votes){

        if (votes.isEmpty()){
            return "Votes can not be tallied with an empty list.  Please add at least one name to the list.";
        }

        HashSet<String> candidatesHash = new HashSet<>();
        candidatesHash.addAll(votes);
        Object[] candidates = candidatesHash.toArray();
        HashMap<String, Integer> talliedVotes = new HashMap<>();

        int highestVotes = 0;
        String winner = "";

        for (Object o : candidates){
            String candidate = o.toString();
            talliedVotes.put(candidate, 0);

            for (String s : votes) {
                if(candidate.equals(s)){
                    int currentVote = talliedVotes.get(candidate);
                    talliedVotes.replace(candidate, currentVote + 1);
                    if(talliedVotes.get(candidate) > highestVotes){
                        winner = candidate;
                        highestVotes = talliedVotes.get(candidate);
                    } else if(talliedVotes.get(candidate) == highestVotes) {
                        winner = winner + " and " + candidate;
                    }
                }
            }
        }
        return winner + " received the most votes!";
    }
    public static ArrayList<String> printTempData(int[][] temps){
        HashSet<Integer> temperatures = new HashSet<>();
        int minTemp = temps[0][0];
        int maxTemp = 0;

        for (int[] arr: temps) {
            for (int i: arr) {
                temperatures.add(i);

                if(i < minTemp){
                    minTemp = i;
                }

                if(i > maxTemp){
                    maxTemp = i;
                }
            }
        }

        ArrayList<String> tempResults = new ArrayList<>();
        tempResults.add("High: " + maxTemp);
        tempResults.add("Low: " + minTemp);


        int tempToFind = minTemp;

        while (tempToFind <= maxTemp){
            if(!temperatures.contains(tempToFind)){
                tempResults.add("Never saw temperature: " + tempToFind);
            }
            tempToFind++;
        }

        return tempResults;
    }
}


