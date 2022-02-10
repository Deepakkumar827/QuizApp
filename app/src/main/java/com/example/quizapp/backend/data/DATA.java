package com.example.quizapp.backend.data;

import android.app.Activity;

import com.example.quizapp.MainActivity;

import java.io.PrintStream;

public class DATA {
    public static String[] subject = new String[]{"MAD", "computer network", "java", "python", "DSA", "compiler design", "C", "C++"};
    //    public static String[] questiontype=new String[]{"SWA", "MCQ", "IVA", "NAT", "MSQ" };
    public static String[] questiontype = new String[]{"SWA", "MCQ", "IVA", "NAT"};
    public static String[] standard = new String[]{ "6", "7", "8", "9", "10", "11", "12", "BTech_CSE", "BTech_Mechanical", "BTech_Civil", "BTech_Electrical", "BA", "BSC", "BCOM", "MBBS" };
//    public static String[] questiontype = new String[]{"SWA", "MCQ", "IVA", "NAT"};
    //    public static String[] creator=new String[]{"Deepak", "Harish","Ritarshi", "Bablu", "Anshul","Ayush", "Abhishek",  "Rupak", "Rohit P Singh" };
    public static String[] test_mode = new String[]{"Single_Mode", "All_In_One", "Single_Mode_instant_checking", "All_In_One_instant_checking"};
    public static String[] test_type = new String[]{"MCQ", "SWA", "IVA", "NAT"};

}