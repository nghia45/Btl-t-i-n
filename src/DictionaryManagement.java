package App;

import java.util.Scanner;

public class DictionaryManagement {

    public static Dictionary dic;

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

    /**
     * function to find word using commandLine.
     */
    public static void dictionaryLookup() {
        Scanner input = new Scanner(System.in);
        Word w = new Word();
        w.setWord_tage(input.nextLine());
        for (int i = 0; i < dic.list.size(); i++) {
            if (w.getWord_tage().equals(dic.list.get(i).getWord_tage())) {
                System.out.println(dic.list.get(i).getWord_explain());
            }
        }
    }
}
