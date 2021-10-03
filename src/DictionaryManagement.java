import java.util.Scanner;

public class DictionaryManagement {

    public static Dictionary dic = new Dictionary;

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