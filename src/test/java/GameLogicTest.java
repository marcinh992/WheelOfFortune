import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

@Test
    void shouldThrowExceptionWhenCannotFindWheelOfFortuneFile(){

   assertThrows(IllegalStateException.class, () -> GameLogic.loadWheelOfFortuneWordsJsonFile("głupota"));
}

    @Test
    void shouldPutObjectsFromJsonFileToArrayList() {

        //given
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("Civil War");
        jsonArray.add("Age of Ultron");
        jsonArray.add("Endgame");
        jsonArray.add("Infinity War");

        List<String> list = new ArrayList<>();


        //when
        list = GameLogic.putWheelOfFortuneWordsFromJsonFileToList(jsonArray);

        //then
        assertEquals(jsonArray, list);
    }

    @Test
    void drawnStringsShouldBeDifferentThanEachOther() {

        //given
        List<String> list = new ArrayList<>();
        list.add("Hawkeye's bow");
        list.add("Capitan America's shield");
        list.add("Vision's mind stone");
        list.add("Doctor Strange's amulet");
        list.add("The Infinity Gauntlet");
        list.add("Ironman's armor");
        list.add("Thor's Mjolnir");

        //when
        String drawnString = GameLogic.drawSecretWord(list);

        //then
        assertNotEquals(GameLogic.drawSecretWord(list), drawnString);
        assertNotEquals(GameLogic.drawSecretWord(list), drawnString);
        assertNotEquals(GameLogic.drawSecretWord(list), drawnString);
        assertNotEquals(GameLogic.drawSecretWord(list), drawnString);
        assertNotEquals(GameLogic.drawSecretWord(list), drawnString);
        assertNotEquals(GameLogic.drawSecretWord(list), drawnString);
    }


}