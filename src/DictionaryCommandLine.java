package App;

import java.util.Scanner;

public class DictionaryCommandLine {

    public static Dictionary dic = new Dictionary();
    /**
     * show all words.
     */
    public static void showAllWords() {
        System.out.println("No\t| English\t\t| Vietnamese");
        for (int i = 1; i <= dic.list.size(); i++) {
            System.out.print(i + "\t");
            System.out.println("| " + dic.list.get(i - 1).getWord_tage()
                    + "\t\t" + "| " + dic.list.get(i - 1).getWord_explain());
        }
    }

    /**
     * call function.
     */
    public static void dictionaryAdvanced() {
        //insertFromFile();
        showAllWords();
        //dictionaryLookup();
    }

    /**
     * function to search word.
     */
    public static void dictionarySearcher() {
         Scanner input = new Scanner(System.in);
         System.out.println("Type to search: ");
         String search = input.nextLine();
         for (int i = 1; i  <= dic.list.size(); i++) {
             if (dic.list.get(i - 1).getWord_tage().contains(search)) {
                 System.out.println(dic.list.get(i - 1).getWord_tage() + "          "
                         + dic.list.get(i - 1).getWord_explain() + "\n");
             }
         }
    }

    /**
     * main function.
     */
    public static void main(String[] args) {
         Dictionary d = new Dictionary();
         Word a = new Word("Hello", "Xin Chào");
         Word b = new Word("Morning", "Buổi sáng");
         Word c = new Word("Pity", "Xinh đẹp");
         d.list.add(a);
         d.list.add(b);
         d.list.add(c);
         showAllWords();
         dictionarySearcher();
         //dictionatyLookup();
    }
}
