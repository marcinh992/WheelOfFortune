public class MenuInfo {
    public static void showMainMenu() {
        System.out.println("Gra Koło Fortuny");
        System.out.println();
        System.out.println(MainClass.STARTGAME + " - Uruchom grę");
        System.out.println(MainClass.SHOWRULES + " - Zasady gry");
        System.out.println(MainClass.EXIT + " - Wyjście z programu");

        System.out.println("Wybierz opcję: ");
    }

    public static void showGameRules() {
        System.out.println("Gra Koło Fortuny informację: ");
        System.out.println("Liczba graczy : 1-4");
        System.out.println("Liczba rund : 4");
        System.out.println("---------------------");
        System.out.println("Zasady: ");
        System.out.println("Gra Koło Fortuny opiera się na odgadnięciu hasła ukrytego za znakami");
        System.out.println("Gracze mają do wyboru dwie opcję - odgadnięcie pojedyńczej litery bądź całego hasła");
        System.out.println("Za każdą jedną literę, która została odkryta gracz otrzymuję 1pkt");
        System.out.println("W przypadku odgadnięcia całego hasła gracz otrzymuję tyle punktów ");
        System.out.println("ile liter zostało nieodsłonionych. Cała gra składa się z " + MainClass.ROUNDSLIMIT +
                "rund, w których");
        System.out.println("gracze odgadują hasło naprzemiennie. Wygrywa gracz z największą liczbą punktów");
        System.out.println(" ");
        System.out.println("---------------------");
        System.out.println(" ");
    }

    public static void showGuessingMenu(Player player){
        System.out.println();
        System.out.println("Aktualnie ruch wykonuje: " + player);
        System.out.println("Dostępne możliwośći: ");
        System.out.println("Wciśnij " + MainClass.GUESSLETTER + " jeżeli chcesz odgadnąć pojedyńczą literę.");
        System.out.println("Wciśnij " + MainClass.GUESSWORD + " jeżeli chcesz odgadnąć całe hasło.");
    }
}