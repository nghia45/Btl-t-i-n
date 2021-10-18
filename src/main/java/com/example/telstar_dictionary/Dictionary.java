package com.example.telstar_dictionary;

import java.util.ArrayList;

public class Dictionary {
    //Contain a list of words and meanings
    public static ArrayList<Word> list = new ArrayList<>();

    //Contain searching history
    public static ArrayList<Word> his = new ArrayList<>();

    public static Trie trie = new Trie();
}
