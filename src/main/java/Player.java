import java.util.*;

public class Player implements Comparable<Player> {

    private String playerName;
    private int playerScore;
    private static final int MAX_PLAYERS_VALUE = 4;

    public static ArrayList<Player> players = new ArrayList<>();

    public Player(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public static void addPlayers(List<String> playersNames) {
        int startingScore = 0;
        for (String name : playersNames) {
            players.add(new Player(name, startingScore));
        }
    }

    public static String printLeaderBoard() {
        Collections.sort(players);
        String place = null;
        int position = 1;
        for (int i = 0; i < players.size(); i++) {
            position = position + i;
            place = "Miejsce " + position + ' ' + players.get(i).getPlayerName() + " z wynikiem "
                    + players.get(i).getPlayerScore() + "pkt";
        }
        return place;
    }

    public static boolean checkMaxPlayers(int playersNumber) {
        return playersNumber <= MAX_PLAYERS_VALUE;
    }

    @Override
    public String toString() {
        return this.getPlayerName();
    }


    @Override
    public int compareTo(Player o) {
        if (this.getPlayerScore() > o.getPlayerScore())
            return -1;
        else if (this.getPlayerScore() < o.getPlayerScore())
            return 1;
        return 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }


}
