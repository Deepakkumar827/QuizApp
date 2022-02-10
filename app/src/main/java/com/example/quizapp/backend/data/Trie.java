package com.example.quizapp.backend.data;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Hashtable;

public class Trie {


    public String name;
    public ArrayList<Trie> child=new ArrayList<>();;
      Trie(String name){
        this.name=name;
    }

}
