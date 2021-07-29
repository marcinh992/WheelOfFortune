import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainClassTest {



    @Test
    void guessedWordShouldBeEqualsSecretWord()  {

        //given
        Player player = new Player("Marcin", 0);
        String input = "junior";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        MainClass.guessWord(scanner, "junior", "", player);

        //then
        assertThat(player.getPlayerScore()).isEqualTo(6);
    }



}