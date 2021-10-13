package com.example.telstar_dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class DictionaryManagement {

    public static Dictionary dic;

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
            FileReader file_reader =
                    new FileReader("src/main/java/com/example/telstar_dictionary/dictionaries.txt");
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
            FileWriter file_writer =
                    new FileWriter("src/main/java/com/example/telstar_dictionary/dictionaries.txt");
            for (Word word : Dictionary.list) {
                file_writer.write(word.to_string() + System.lineSeparator());
            }
            file_writer.close();
        } catch (Exception e) {
        }
    }

    /**
     * insert to the dictionary from the file.
     */
    public static void insertHistoryFromFile() {
        try {
            FileReader file_reader =
                    new FileReader("src/main/java/com/example/telstar_dictionary/history.txt");
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
                Dictionary.his.add(word);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Tranfers the words in history list to the file.
     */
    public static void historyExportToFile() {
        try {
            FileWriter file_writer =
                    new FileWriter("src/main/java/com/example/telstar_dictionary/history.txt");
            for (Word word : Dictionary.his) {
                file_writer.write(word.to_string() + System.lineSeparator());
            }
            file_writer.close();
        } catch (Exception e) {
        }
    }

}
