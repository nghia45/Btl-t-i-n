package Dictionary;

import java.util.Objects;
import java.util.Scanner;

import static Dictionary.DictionaryCommandline.dictionarySearcher;
import static Dictionary.DictionaryCommandline.showAllWords;
import static Dictionary.DictionaryManagement.*;

public class Main {

    public static void main(String[] args) {
        //Dictionary list initial
        insertFromFile();
        boolean exit_flag = false;
        while (!exit_flag) {
            Scanner input = new Scanner(System.in);
            //Show the menu
            System.out.println("Menu:");
            System.out.println("1.Tìm kiếm");
            System.out.println("2.Hiển thị tất cả");
            System.out.println("3.Sửa từ điển");
            System.out.println("4.Thoát");
            String order = input.next();
            if (Objects.equals(order, "1")) {
                //Search a word
                String order_1;
                do {
                    dictionarySearcher();
                    System.out.println("1.Tìm kiếm");
                    System.out.println("2.Quay lại");
                    Scanner input_1 = new Scanner(System.in);
                    order_1 = input_1.next();
                }
                while (Objects.equals(order_1, "1"));
            } else if (Objects.equals(order, "2")) {
                //Show all words
                String order_2;
                showAllWords();
                System.out.println("1.Menu");
                Scanner input_2 = new Scanner(System.in);
                order_2 = input_2.next();
            } else if (Objects.equals(order, "3")) {
                //Change something in the dictionary
                boolean exit_flag_3 = false;
                do {
                    System.out.println("Menu:");
                    System.out.println("1.Thêm từ mới");
                    System.out.println("2.Sửa từ");
                    System.out.println("3.Xoá từ");
                    System.out.println("4.Quay lại");
                    String order_3;
                    Scanner input_3 = new Scanner(System.in);
                    order_3 = input_3.next();
                    if (Objects.equals(order_3, "1")) {
                        addWord();
                        dictionaryExportToFile();
                    } else if (Objects.equals(order_3, "2")) {
                        fixWord();
                        dictionaryExportToFile();
                    } else if (Objects.equals(order_3, "3")) {
                        deleteWord();
                        dictionaryExportToFile();
                    } else {
                        exit_flag_3 = true;
                    }
                } while (!exit_flag_3);
            } else if (Objects.equals(order, "4")) {
                //Exit the application
                exit_flag = true;
            }
        }
    }

}