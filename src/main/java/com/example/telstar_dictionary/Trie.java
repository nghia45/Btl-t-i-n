package com.example.telstar_dictionary;

import java.util.HashMap;
import java.util.Map;
public class Trie
{
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        String meaning;
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word, String ex_word) {
        TrieNode curr = root;
        for(int i=0;i < word.length();i++) {
            char ch = word.charAt(i);
            TrieNode node = curr.children.get(ch);
            if(node == null) {
                node = new TrieNode();
                curr.children.put(ch, node);
            }
            curr = node;
        }
        //luu gia tri cuoi tu = true
        curr.endOfWord = true;
        curr.meaning = ex_word;
    }

    //kiem tra xem co tu trong list chua
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i < word.length();i++) {
            char ch = word.charAt(i);
            TrieNode node = curr.children.get(ch);
            if(node == null) {
                return false;
            }
            curr = node;
        }
        return curr.endOfWord;
    }

    //tim va tra lai tu can t
    public String search2(String word) {
        TrieNode curr = root;
        for(int i=0;i < word.length();i++) {
            char ch = word.charAt(i);
            TrieNode node = curr.children.get(ch);
            if(node == null) {
                return "";
            }
            curr = node;
        }

        return curr.meaning;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode curr,String word, int index) {
        if(index >= word.length()) {
            if(!curr.endOfWord) {
                return false;
            }
            curr.endOfWord = false;
            return curr.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = curr.children.get(ch);
        if(node == null) {
            return false;
        }
        boolean shouldDeleteCurrNode = delete(node, word, index+1);
        if(shouldDeleteCurrNode) {
            curr.children.remove(ch);
            return curr.children.size() == 0;
        }
        return false;
    }
}
