package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 luis curtiellas
 */

import java.io.*;
import java.util.*;

public class WordFinder {
    public static void main(String[] args) throws FileNotFoundException {
        String text = readFile();
        String replace = "utilize";

        text = replaceAll(text, replace);

        //print fixed text
        System.out.println(text);
        printFile(text);

        System.out.println( "\nOutput also in exercise45_output.txt" );
    }

    public static String readFile() throws FileNotFoundException {
        StringBuilder text = new StringBuilder();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the text file.\nExample \"exercise45_input.txt\" ");
        String fileName = scan.next();

        //initializing the file scan tool
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            //read entire line
            text.append(sc.nextLine());
            text.append(" ");
        }

        sc.close();

        return text.toString();
    }

    public static String replaceAll(String text, String replace) {
        int index;

        index = findString(text, replace);
        while (index != -1) {
            text = replaceSpecific(text, replace, index);

            index = findString(text, replace);
        }

        return text;
    }

    public static String replaceSpecific(String text, String replace, int index) {
        //return fixed string
        return text.substring(0, index) + ("use") + text.substring(index + replace.length());
    }

    public static int findString(String text, String replace) {
        return text.indexOf(replace);
    }

    private static void printFile(String output) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("exercise45_output.txt"));
            bw.write(output);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}