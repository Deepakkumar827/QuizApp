package com.example.quizapp.backend.data;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Hashtable;

public class Dir {

    public static Trie head;


    public  static Trie getInstanceOfDir(){
        if(head==null){

            call();
        }
        return head;
    }






    private static void call(){


        head=new Trie("head");
        head.child.add(new Trie("all"));
        head.child.get(0).child.add(new Trie("10"));
        head.child.get(0).child.add(new Trie("11"));
        head.child.get(0).child.add(new Trie("12"));
        head.child.get(0).child.add(new Trie("BTech CSE"));
        head.child.get(0).child.add(new Trie("BTech Mechanical"));
        head.child.get(0).child.add(new Trie("BTech ECE"));
        head.child.get(0).child.add(new Trie("BTech Civil"));




        head.child.get(0).child.get(0).child.add(new Trie("Science"));
        head.child.get(0).child.get(0).child.get(0).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("Social Science"));
        head.child.get(0).child.get(0).child.get(1).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("Mathematics"));
        head.child.get(0).child.get(0).child.get(2).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("English"));
        head.child.get(0).child.get(0).child.get(3).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("Sanskrit"));
        head.child.get(0).child.get(0).child.get(4).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("Hindi"));
        head.child.get(0).child.get(0).child.get(5).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("Tamil"));
        head.child.get(0).child.get(0).child.get(6).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("Telugu"));
        head.child.get(0).child.get(0).child.get(7).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("Malayalam"));
        head.child.get(0).child.get(0).child.get(8).child.add(new Trie("mixed"));
        head.child.get(0).child.get(0).child.add(new Trie("Kannada"));
        head.child.get(0).child.get(0).child.get(9).child.add(new Trie("mixed"));



        head.child.get(0).child.get(1).child.add(new Trie("Chemistry"));
        head.child.get(0).child.get(1).child.get(0).child.add(new Trie("mixed"));
        head.child.get(0).child.get(1).child.add(new Trie("Physics"));
        head.child.get(0).child.get(1).child.get(1).child.add(new Trie("mixed"));
        head.child.get(0).child.get(1).child.add(new Trie("Biology"));
        head.child.get(0).child.get(1).child.get(2).child.add(new Trie("mixed"));
        head.child.get(0).child.get(1).child.add(new Trie("Mathematics"));
        head.child.get(0).child.get(1).child.get(3).child.add(new Trie("mixed"));
        head.child.get(0).child.get(1).child.add(new Trie("English"));
        head.child.get(0).child.get(1).child.get(4).child.add(new Trie("mixed"));
        head.child.get(0).child.get(1).child.add(new Trie("Hindi"));
        head.child.get(0).child.get(1).child.get(5).child.add(new Trie("mixed"));
        head.child.get(0).child.get(1).child.add(new Trie("Tamil"));
        head.child.get(0).child.get(1).child.get(6).child.add(new Trie("mixed"));




        head.child.get(0).child.get(2).child.add(new Trie("Chemistry"));
        head.child.get(0).child.get(2).child.get(0).child.add(new Trie("mixed"));
        head.child.get(0).child.get(2).child.add(new Trie("Physics"));
        head.child.get(0).child.get(2).child.get(1).child.add(new Trie("mixed"));
        head.child.get(0).child.get(2).child.add(new Trie("Biology"));
        head.child.get(0).child.get(2).child.get(2).child.add(new Trie("mixed"));
        head.child.get(0).child.get(2).child.add(new Trie("Mathematics"));
        head.child.get(0).child.get(2).child.get(3).child.add(new Trie("mixed"));
        head.child.get(0).child.get(2).child.add(new Trie("English"));
        head.child.get(0).child.get(2).child.get(4).child.add(new Trie("mixed"));
        head.child.get(0).child.get(2).child.add(new Trie("Hindi"));
        head.child.get(0).child.get(2).child.get(5).child.add(new Trie("mixed"));
        head.child.get(0).child.get(2).child.add(new Trie("Tamil"));
        head.child.get(0).child.get(2).child.get(6).child.add(new Trie("mixed"));





        head.child.get(0).child.get(3).child.add(new Trie("Java"));
        head.child.get(0).child.get(3).child.get(0).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("C++"));
        head.child.get(0).child.get(3).child.get(1).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Python"));
        head.child.get(0).child.get(3).child.get(2).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Mobile Application Development"));
        head.child.get(0).child.get(3).child.get(3).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Computer Organization And Architecture"));
        head.child.get(0).child.get(3).child.get(4).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("C"));
        head.child.get(0).child.get(3).child.get(5).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Javascript"));
        head.child.get(0).child.get(3).child.get(6).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Computer Network"));
        head.child.get(0).child.get(3).child.get(7).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Compiler Design"));
        head.child.get(0).child.get(3).child.get(8).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Full Stack Development"));
        head.child.get(0).child.get(3).child.get(9).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Data Structures"));
        head.child.get(0).child.get(3).child.get(10).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Operating Systems"));
        head.child.get(0).child.get(3).child.get(11).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Software Engineering"));
        head.child.get(0).child.get(3).child.get(12).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Database Management Systems"));
        head.child.get(0).child.get(3).child.get(12).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Algorithms"));
        head.child.get(0).child.get(3).child.get(13).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Information Security"));
        head.child.get(0).child.get(3).child.get(13).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Algorithms"));
        head.child.get(0).child.get(3).child.get(13).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Artificial Intelligence"));
        head.child.get(0).child.get(3).child.get(14).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Machine Learning"));
        head.child.get(0).child.get(3).child.get(15).child.add(new Trie("mixed"));
        head.child.get(0).child.get(3).child.add(new Trie("Deep Learning"));
        head.child.get(0).child.get(3).child.get(16).child.add(new Trie("mixed"));




        head.child.get(0).child.get(4).child.add(new Trie("Engineering Mechanics"));
        head.child.get(0).child.get(4).child.get(0).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Fluid Mechanics and Hydraulic Machines"));
        head.child.get(0).child.get(4).child.get(1).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Engineering Thermodynamics"));
        head.child.get(0).child.get(4).child.get(2).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Machine Drawing"));
        head.child.get(0).child.get(4).child.get(3).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Elements of Electronics"));
        head.child.get(0).child.get(4).child.get(4).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Mechanics of Solids"));
        head.child.get(0).child.get(4).child.get(5).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Thermal Engineering"));
        head.child.get(0).child.get(4).child.get(6).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Heat and Mass Transfer"));
        head.child.get(0).child.get(4).child.get(7).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Dynamics of Machines"));
        head.child.get(0).child.get(4).child.get(8).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Advanced Manufacturing Technology"));
        head.child.get(0).child.get(4).child.get(9).child.add(new Trie("all"));
        head.child.get(0).child.get(4).child.add(new Trie("Surface Engineering"));
        head.child.get(0).child.get(4).child.get(10).child.add(new Trie("all"));





        head.child.get(0).child.get(5).child.add(new Trie("Cellular Mobile Communication"));
        head.child.get(0).child.get(5).child.get(0).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Circuits and Networks"));
        head.child.get(0).child.get(5).child.get(1).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Electronic Devices and Circuits"));
        head.child.get(0).child.get(5).child.get(2).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Electromagnetic Waves and Fields"));
        head.child.get(0).child.get(5).child.get(3).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Digital System Design"));
        head.child.get(0).child.get(5).child.get(4).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Transmission Lines and Waveguides"));
        head.child.get(0).child.get(5).child.get(5).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Signals and Systems"));
        head.child.get(0).child.get(5).child.get(6).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Microwave and Optical Engineering"));
        head.child.get(0).child.get(5).child.get(7).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("VLSI Design"));
        head.child.get(0).child.get(5).child.get(8).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Wireless Communication"));
        head.child.get(0).child.get(5).child.get(9).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Embedded System"));
        head.child.get(0).child.get(5).child.get(10).child.add(new Trie("all"));
        head.child.get(0).child.get(5).child.add(new Trie("Satellite Communication Systems"));
        head.child.get(0).child.get(5).child.get(11).child.add(new Trie("all"));





        head.child.get(0).child.get(6).child.add(new Trie("Building Materials"));
        head.child.get(0).child.get(6).child.get(0).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Structural Design"));
        head.child.get(0).child.get(6).child.get(1).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Building Construction"));
        head.child.get(0).child.get(6).child.get(2).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Mechanics of Fluids"));
        head.child.get(0).child.get(6).child.get(3).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Building Planning and Drawing"));
        head.child.get(0).child.get(6).child.get(4).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Engineering Geology"));
        head.child.get(0).child.get(6).child.get(5).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Physical Education"));
        head.child.get(0).child.get(6).child.get(6).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Computational Methods"));
        head.child.get(0).child.get(6).child.get(7).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Fluid Flow and Hydraulic"));
        head.child.get(0).child.get(6).child.get(8).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Computer Aided Design"));
        head.child.get(0).child.get(6).child.get(9).child.add(new Trie("all"));
        head.child.get(0).child.get(6).child.add(new Trie("Engineering Economics"));
        head.child.get(0).child.get(6).child.get(10).child.add(new Trie("all"));

    }
}
