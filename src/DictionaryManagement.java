import java.util.Scanner;

public class DictionaryManagement {

    private static Dictionary dic;

    /**
     * input function.
     */
    public static void insertFromCommandline() {
        Word ad = new Word();
        Scanner input = new Scanner(System.in);
        ad.setWord_tage(input.nextLine());
        ad.setWord_explain(input.nextLine());
        dic.list.add(ad);

    }
}
