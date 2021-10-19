package com.example.telstar_dictionary;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;


public class DictionaryManagement {


    /**
     * insert to the dictionary from the file.
     */
    public static void insertFromFile() {
        try {
            Scanner scanner = new Scanner(new File("src/main/java/com/example/telstar_dictionary/dictionaries.txt"), StandardCharsets.UTF_8);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (data.equals("@")) {
                    data = scanner.nextLine();
                    String word = data;
                    String explain = "";
                    while (!data.equals("#")) {
                        data = scanner.nextLine();
                        explain += data + "\n";
                        if (data.equals("#")) {
                            continue;
                        }
                    }
                    Word temp_word = new Word(word, explain);
                    Dictionary.list.add(temp_word);
                    Dictionary.trie.insert(temp_word.getWord_target(),temp_word.getWord_explain());
                }
            }
            //System.out.println("done!");
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
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
                file_writer.write("@" + System.lineSeparator());
                file_writer.write(word.to_string() + System.lineSeparator());
            }
            file_writer.write("#" + System.lineSeparator());
            file_writer.close();
        } catch (Exception e) {
        }
    }

    /**
     * insert to the dictionary from the file.
     */
    public static void insertHistoryFromFile() {
        try {
            FileReader file_reader = new FileReader("src/main/java/com/example/telstar_dictionary/history.txt");
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
            FileWriter file_writer = new FileWriter("src/main/java/com/example/telstar_dictionary/history.txt");
            for (Word word : Dictionary.his) {
                file_writer.write(word.getWord_target().toLowerCase(Locale.ROOT) + System.lineSeparator());
            }
            file_writer.close();
        } catch (Exception e) {
        }
    }

}
