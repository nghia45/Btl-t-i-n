import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class DictionaryCommandline {
    public static void showAllWords() {
        System.out.println("No\t| English\t\t| Vietnamese");
        for (int i = 1; i < Dictionary.size(); i++) {
            System.out.print(i + "\t");
            System.out.println("| " + Dictionary.get(i - 1).word_target()
                    + "\t\t" + "| " + Dictionary.get(i - 1).word_explain());
        }
    }

    public static void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public static void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
        dictionaryLookUp();
    }

    public static ArrayList<String> dictionarySearcher() {
        String word;
        Scanner search = new Scanner(System.in);
        word = search.next();
        ArrayList<String> searchedList = new ArrayList<String>();
        for(int i = 0; i < dic.list.size(); i++){
            boolean state = true;
            for(int j = 0; j < word.length(); j++){
                if(dic.list[i].getWordTage()[j] != word[i]){
                    state = false;
                    break;
                }
                if(state){
                    searchedList.add(dic.list[i]);
                }
            }
        }
        Dictionary searchedDic = new Dictionary(searchedList);
        return searchedList;
    }
}
