/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

import java.util.List;

/**
 *
 * @author Admin
 */
public class AutoCompleteWithTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("amazon");
        trie.insert("amazon prime");
        trie.insert("amazing");
        trie.insert("amazing spider man");
        trie.insert("amazed");
        trie.insert("alibaba");
        trie.insert("ali express");
        trie.insert("ebay");
        trie.insert("walmart");
        trie.insert("bbq");
        trie.insert("big world");
        trie.insert("big zero");
        List a = trie.autocomplete("ali");
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
