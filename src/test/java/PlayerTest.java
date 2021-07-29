import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @BeforeEach
    void playersListClear() {
        Player.players.clear();
    }

    @Test
    void playerListShouldBeEmptyBeforeAddingPlayers() {

        //then
        assertThat(Player.players).isEmpty();
    }

    @Test
    void playerListShouldNotBeEmptyAfterAddingPlayerToList() {

        //given
        List<String> playerName = new ArrayList<>();
        playerName.add("Marcin");

        //when
        Player.addPlayers(playerName);

        //then
        assertThat(Player.players).isNotEmpty();
        assertThat(Player.players.get(0).getPlayerName()).isEqualTo("Marcin");
    }

    @Test
    void newlyPlayerShouldStartingWithZeroScore() {

        //given
        List<String> playerName = new ArrayList<>();
        playerName.add("Ironman");
        playerName.add("CapAmerica");
        playerName.add("Hulk");

        //when
        Player.addPlayers(playerName);

        //then
        assertThat(Player.players).isNotEmpty();
        assertThat(Player.players.get(0).getPlayerScore()).isEqualTo(0);
        assertThat(Player.players.get(1).getPlayerScore()).isEqualTo(0);
        assertThat(Player.players.get(2).getPlayerScore()).isEqualTo(0);
    }

    @Test
    void playersAfterGameShouldBeSortedFromBestToWorstScore() {

        //given
        List<String> playerName = new ArrayList<>();
        playerName.add("Superman");
        playerName.add("Batman");
        playerName.add("Aquaman");
        Player.addPlayers(playerName);

        Player.players.get(0).setPlayerScore(5);
        Player.players.get(1).setPlayerScore(10);
        Player.players.get(2).setPlayerScore(15);

        //when
        Player.printLeaderBoard();

        //then
        assertThat(Player.players.get(0).getPlayerScore()).isEqualTo(15);
        assertThat(Player.players.get(1).getPlayerScore()).isEqualTo(10);
        assertThat(Player.players.get(2).getPlayerScore()).isEqualTo(5);
    }

    //pomyśleć nad zmianą nazwy
    @Test
    void leaderboardShouldBePrintedCorrectly(){

        //given
        List<String> playerName = new ArrayList<>();
        playerName.add("Hawkeye");
        Player.addPlayers(playerName);

        Player.players.get(0).setPlayerScore(5);

        //when
        Player.printLeaderBoard();

        //then
        assertEquals("Miejsce 1 Hawkeye z wynikiem 5pkt", Player.printLeaderBoard());
    }


}