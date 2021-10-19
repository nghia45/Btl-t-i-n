package Dictionary;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DictionaryManagement {

    public static Dictionary dic;

//    public static void insertFromCommandline() {
//        Word ad = new Word();
//        Scanner input = new Scanner(System.in);
//        ad.setWord_tage(input.nextLine());
//        ad.setWord_explain(input.nextLine());
//        dic.list.add(ad);
//    }

    /**
     * function to find word using commandLine.
     */
    public static void dictionaryLookup() {
        Scanner input = new Scanner(System.in);
        Word word = new Word();
        word.setWord_target(input.nextLine());
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (word.getWord_target().equals(Dictionary.list.get(i).getWord_target())) {
                System.out.println(Dictionary.list.get(i).getWord_explain());
            }
        }
    }

    /**
     * insert to the dictionary from the file.
     */
    public static void insertFromFile() {
        try {
            FileInputStream fileInPutStream = new FileInputStream("src/Dictionary/dictionaries.txt");
            Reader file_reader = new java.io.InputStreamReader(fileInPutStream, StandardCharsets.UTF_8);
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String line = "";
            while (true) {
                line = buffered_reader.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split("\\s+");
                Word word = new Word();
                word.setWord_target(txt[0]);
                String explain = "";
                for (int i = 1; i < txt.length; i++) {
                    explain += txt[i] + " ";
                }
                word.setWord_explain(explain);
                Dictionary.list.add(word);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Tranfers the words in dictionary list to the file.
     */
    public static void dictionaryExportToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/Dictionary/dictionaries.txt");
            Writer file_writer = new java.io.OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(file_writer);
            for (Word word : Dictionary.list) {
                bw.write(word.to_string() + System.lineSeparator());
            }
            bw.close();
        } catch (Exception e) {
        }
    }

    /**
     * Add a word into file.
     */
    public static void addWord() {
        Scanner input = new Scanner(System.in);
        Word newWord = new Word();
        System.out.println("Nhap tu tieng Anh: ");
        newWord.setWord_target(input.nextLine());
        boolean exist = false;
        for (int i = 0; i < Dictionary.list.size(); i++) {
            //Nếu từ đã tồn tại
            if (newWord.getWord_target().equals(Dictionary.list.get(i).getWord_target())) {
                System.out.println("Từ này đã có trong từ điển!");
                exist = true;
                break;
            }
        }
        if (!exist) {
            System.out.println("Nhap nghia tieng Viet: ");
            newWord.setWord_explain(input.nextLine());
            Dictionary.list.add(newWord);
            System.out.println("Thêm thành công");
        }
    }

    /**
     * Delete a word in the file.
     */
    public static void deleteWord() {
        Scanner input = new Scanner(System.in);
        Word toDeleteWord = new Word();
        System.out.println("Nhập từ bạn muốn xoá: ");
        toDeleteWord.setWord_target(input.next());
        boolean exist = false;
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (toDeleteWord.getWord_target().equals(Dictionary.list.get(i).getWord_target())) {
                Dictionary.list.remove(i);
                System.out.println("Xoá thành công");
                exist = true;
                break;
            }
        }
        //Nếu từ không có trong từ điển
        if (!exist) {
            System.out.println("Từ này không có để xoá!");
        }
    }

    /**
     * Change the meaning of a word in dictionary.
     */
    public static void fixWord() {
        Scanner input = new Scanner(System.in);
        Word toFixWord = new Word();
        System.out.println("Nhap tu ban muon sua: ");
        toFixWord.setWord_target(input.next());
        boolean exist = false;
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (toFixWord.getWord_target().equals(Dictionary.list.get(i).getWord_target())) {
                System.out.println("Nhap nghia ban muon sua: ");
                Scanner input_2 = new Scanner(System.in);
                Dictionary.list.get(i).setWord_explain(input_2.nextLine());
                System.out.println("Sửa thành công");
                exist = true;
                break;
            }
        }
        //Nếu không có trong từ điển.
        if (!exist) {
            System.out.println("Không tìm thấy từ này trong từ điển!");
        }
    }
}