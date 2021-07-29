import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainClass {

    static final int STARTGAME = 1;
    static final int SHOWRULES = 2;
    static final int EXIT = 3;

    static final int GUESSLETTER = 1;
    static final int GUESSWORD = 2;

    static final int ROUNDSLIMIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != EXIT) {
            MenuInfo.showMainMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case STARTGAME:
                    System.out.println("Podaj ilość graczy:");
                    int playersNumber = GameLogic.getPlayerNumber(scanner);
                    if (Player.checkMaxPlayers(playersNumber)) {
                        List<String> playersNames = GameLogic.getPlayersName(scanner, playersNumber);
                        Player.addPlayers(playersNames);
                        gameLoop();
                        Player.printLeaderBoard();
                    }
                    break;
                case SHOWRULES:
                    MenuInfo.showGameRules();
                    break;
                case EXIT:
                    System.out.println("Hej, dzięki za grę! Do następnego! ^^");
                    break;
                default:
                    System.out.println("Wybrano błędne polecenie, wybierz " + STARTGAME + ", " + SHOWRULES + " lub " + EXIT);


            }
        }


    }


    public static void gameLoop() {
        for (int round = 1; round <= ROUNDSLIMIT; round++) {
            System.out.println("rudna: " + round);
            roundLoop();
        }
    }

    public static void roundLoop() {
        Scanner scanner = new Scanner(System.in);

        String secretWord = GameLogic.drawSecretWord(GameLogic.putWheelOfFortuneWordsFromJsonFileToList
                (Objects.requireNonNull(GameLogic.loadWheelOfFortuneWordsJsonFile("src/main/resources/WheelOfFortuneWords.json")))).toLowerCase();

        String guessess = "";
        String word = "";

        boolean notDone = true;

        while (notDone) {

            notDone = false;

            for (int currentPlayer = 0; currentPlayer < Player.players.size(); currentPlayer++) {

                notDone = hideSecretWord(secretWord, guessess,notDone);

                if (!notDone){
                    break;
                }

                MenuInfo.showGuessingMenu(Player.players.get(currentPlayer));

                int option2 = scanner.nextInt();
                scanner.nextLine();
                switch (option2){
                    case GUESSLETTER:
                        guessess = guessLetter(scanner, secretWord, guessess, Player.players.get(currentPlayer));
                        break;
                    case GUESSWORD:
                        word = guessWord(scanner, secretWord, guessess, Player.players.get(currentPlayer));
                        break;
                    default:
                        System.out.println("Nieprawidłowa akcja");
                }
                if (secretWord.equalsIgnoreCase(guessess) || secretWord.equalsIgnoreCase(word)) {
                    break;
                }
            }
            if (secretWord.equalsIgnoreCase(guessess) || secretWord.equalsIgnoreCase(word)) {
                break;
            }
        }
    }

    public static String guessLetter(Scanner scanner, String secretWord, String guessess, Player player) {
        System.out.print(" Podaj literę: ");
        String letter = scanner.next();

        if (secretWord.contains(letter) && !guessess.contains(letter)) {
            guessess += letter;
            int temporaryPointsHolder = StringUtils.countMatches(secretWord, letter);
            System.out.println("Zgadłeś! Na Twoje konto trafia: " + temporaryPointsHolder + "pkt");
            int pointsCounter = player.getPlayerScore() + temporaryPointsHolder;
            player.setPlayerScore(pointsCounter);
        } else {
            System.out.println("Pudło!");
        }
        return guessess;
    }

    public static String guessWord(Scanner scanner, String secretWord, String guessess, Player player) {
        System.out.println("Podaj całe hasło: ");
         String word = scanner.next();

        if (secretWord.equalsIgnoreCase(word)) {
            int pointsFromGuessWord = secretWord.length() - StringUtils.countMatches(secretWord,guessess);
            System.out.println("Gratulację " + player + "!!" + " Odgadłeś hasło prawidłowo!");
            System.out.println("Na Twoje konto trafia: " + pointsFromGuessWord + "pkt");
            player.setPlayerScore(pointsFromGuessWord);
        } else
            System.out.println("Pudło!");
        return word;
    }
//spróbować wkomponować StringBuildera zamiast sout'a StringBuilder.append - chyba i zwrócić stringa, który jest w stringbuilderze
    private static boolean hideSecretWord(String secretWord, String guessess, boolean notDone) {
        for (char secretLetter : secretWord.toCharArray()) {
            //The java string indexOf() method returns index of given character value or substring. If it is not found, it returns -1. The index counter starts from zero.
            if (guessess.indexOf(secretLetter) == -1) {
                System.out.print('_');
                notDone = true;
            } else {
                System.out.print(secretLetter);
            }
        }
        return notDone;
    }
}
