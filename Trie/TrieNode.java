/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TrieNode {

    public char data;
    public LinkedList children;
    public TrieNode parent;
    public boolean isEnd;

    public TrieNode(char c) {
        data = c;
        children = new LinkedList();
        isEnd = false;
    }

    public TrieNode getChild(char c) {
        if (children != null) {
            for (Object eachChild : children) {//chu y convert kieu
                TrieNode x = (TrieNode)eachChild;
                if(x.data==c)
                    return x;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    protected List getWords(){
        List list = new ArrayList();
        if(isEnd){
            list.add(toString());
        }
        if(children!=null){
            for(int i=0;i<children.size();i++){
                if(children.get(i)!=null){
                    TrieNode x = (TrieNode)children.get(i);
                    list.addAll(x.getWords());
                }
            }
        }
        return list;
    }

    @Override
    public String toString() {
        if (parent == null) {
            return "";
        } else {
            return parent.toString() + new String(new char[]{data});
        }
    }
}
