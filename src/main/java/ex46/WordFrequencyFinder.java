package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 luis curtiellas
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequencyFinder
{
    public static void main( String[] args ) throws FileNotFoundException {
        ArrayList <Map <String, String>> wordList = new ArrayList<>();
        String text = readFile();

        //count and remove each word in the text
        String usedText = countAndRemove(text, wordList);

        //sort the list
        wordList.sort(Comparator.comparing(map -> map.get("Count")));

        //output
        System.out.println( printOutput(wordList) );
    }

    public static String readFile() throws FileNotFoundException {
        StringBuilder text = new StringBuilder();

        //initializing the file scan tool
        File file = new File("exercise46_input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            //read entire line
            text.append(sc.nextLine());
            text.append(" ");
        }

        sc.close();
        return text.toString();
    }

    public static String[] splitFirstWord( String text )
    {
        return text.split(" ", 2);
    }

    public static String countAndRemove(String text, ArrayList <Map <String, String>> wordList)
    {
        String[] arr = splitFirstWord(text);

        String replace = arr[0];

        int counter = 0;

        int index = findString(text, replace);

        while (index != -1) {
            text = replaceSpecific(text, replace, index);

            index = findString(text, replace);

            counter++;
        }

        addToList(replace, String.valueOf(counter), wordList);

        if (!text.equals(""))
            return countAndRemove(text, wordList);

        return text;
    }

    public static String replaceSpecific(String text, String replace, int index) {
        //return fixed string, the part before plus the part after, omitting the space after the word
        return text.substring(0, index) + text.substring(index + replace.length() + 1);
    }

    public static int findString(String text, String replace) {
        return text.indexOf(replace);
    }

    public static void addToList(String word, String count, ArrayList <Map <String, String>> wordList)
    {
        wordList.add( Map.of ("Word", word, "Count", count));
    }

    public static String printOutput(ArrayList <Map <String, String>> wordList) {
        StringBuilder builder = new StringBuilder();
        String word, countString;
        int count;
        int maxLength = 0;
        int size = wordList.size();

        //find the longest word
        for (int a = 0; a < size; a++) {
            if ( wordList.get(a).get("Word").length() > maxLength)
                maxLength = wordList.get(a).get("Word").length();
        }

        //build each word, backwards for loop to output from larger to lower count
        for (int a = size - 1; a >= 0; a--) {
            word = wordList.get(a).get("Word");
            countString = wordList.get(a).get("Count");
            count = Integer.parseInt(countString);

            builder.append(word);

            for (int b = word.length(); b < maxLength + 1; b++)
                builder.append(" ");

            for (int b = 0; b < count; b++)
                builder.append("*");

            builder.append("\n");
        }

        return builder.toString();
    }

}
