package Dictionary;

import java.util.Scanner;

import static Dictionary.DictionaryManagement.dictionaryLookup;
import static Dictionary.DictionaryManagement.insertFromFile;


public class DictionaryCommandline {
    /**
     * Show all the words in dictionary.
     */
    public static void showAllWords() {
        System.out.println("No\t| English\t\t| Vietnamese");
        for (int i = 1; i <= Dictionary.list.size(); i++) {
            System.out.format("%-5s %-15s %-15s",
                    i,
                    Dictionary.list.get(i - 1).getWord_target(),
                    Dictionary.list.get(i - 1).getWord_explain()

            );
            System.out.println();
        }
    }

//    public static void dictionaryBasic() {
//        insertFromCommandline();
//        showAllWords();
//    }

    /**
     * Include 3 functions.
     */
    public static void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
        dictionaryLookup();
    }

    /**
     * Search a word.
     */
    public static void dictionarySearcher() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type to search: ");
        String search = input.nextLine();
        for (int i = 1; i <= Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i - 1).getWord_target().contains(search)) {
                System.out.println(Dictionary.list.get(i - 1).getWord_target() + "     "
                        + Dictionary.list.get(i - 1).getWord_explain());
            }
        }
    }

}
