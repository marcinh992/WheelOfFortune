import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {


    public static JSONArray loadWheelOfFortuneWordsJsonFile(String filePath){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(filePath));
            JSONArray wheelOfFortuneWords = (JSONArray) obj;


            return wheelOfFortuneWords;

        } catch (Exception e){
            throw new IllegalStateException(e);
        }
    }

    public static List<String> putWheelOfFortuneWordsFromJsonFileToList(JSONArray jsonArray){
        List<String> secretWordsList = new ArrayList<>();
        for (int i = 0; i <jsonArray.size() ; i++) {
            secretWordsList.add(jsonArray.get(i).toString());
        }
        return secretWordsList;
    }

    public static String drawSecretWord(List list){
        Random random = new Random();
        int randomSecretWord = random.nextInt(list.size());
        String secretString = list.get(randomSecretWord).toString();
        list.remove(randomSecretWord);

        return secretString;
    }


    public static int getPlayerNumber(Scanner scanner){
        int playersNumber= scanner.nextInt();
        scanner.nextLine();

        return playersNumber;
    }

    public static List<String> getPlayersName(Scanner scanner, int playersNumber){
        List<String> playersName = new ArrayList<>();
        for (int i = 1; i <= playersNumber; i++) {
            System.out.println("Graczu " + i + ", wpisz swoje imię: ");
            String playerName = scanner.next();
            playersName.add(playerName);
        }
        return playersName;
    }

}