import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Dictionary {
    public static ArrayList<Word> list = new ArrayList<Word>();

    Dictionary(ArrayList<Word> _list){
        this.list = _list;
    }

    public void readFromFile(String nameFile) {
        try {
            FileReader fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split("\\s+");
                Word wd = new Word();
                wd.setWord_tage(txt[0]);
                wd.setWord_explain(txt[1]);
                list.add(wd);
            }
        } catch (Exception e) {
        }
    }

    public void writeToFile(String nameFile) {
        try {
            FileWriter fw = new FileWriter(nameFile);
            BufferedWriter bw = new BufferedWriter(fr);
            String line = "";
            for(Word wd : list) {
                bw.write(wd.to_string);
                bw.newLine();
            }
            fw.close();
            bw.close();
        } catch (Exception e) {
        }
    }

    public static void getSize(){

    }
}