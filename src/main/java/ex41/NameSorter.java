package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 luis curtiellas
 */

import java.io.*;
import java.util.*;

public class NameSorter
{
    public static void main( String[] args ) throws FileNotFoundException {
        //list of maps (key, "firstName") (key, "lastName")
        ArrayList <Map <String, String>> employees = new ArrayList<>();

        //enter the values to the list
        int numNames = readNames(employees);

        //sort the list
        employees.sort(Comparator.comparing(map -> map.get("Last Name")));

        //print the sorted list
        System.out.println( printNames(employees, numNames) );

        //print to file
        printFile( printNames(employees, numNames) );

        System.out.println( "Output also in exercise41_output.txt" );
    }

    public static int readNames( ArrayList <Map <String, String>> employees ) throws FileNotFoundException {
        int numNames = 0;
        String line;
        String[] names = new String[2];

        //initializing the file scan tool
        File file = new File( "exercise41_input.txt" );
        Scanner sc = new Scanner(file);

        //check if line is empty to read it
        while ( sc.hasNextLine() )
        {
            //counts the number of lines read, i.e. number of names
            numNames++;

            //read entire line
            line = sc.nextLine();

            names = extractNames(line);

            addToList(names[1], names[0], employees);
        }

        sc.close();

        return numNames;
    }

    public static void addToList(String firstName, String lastName, ArrayList <Map <String, String>> employees)
    {
        employees.add( Map.of ("First Name", firstName, "Last Name", lastName));
    }

    public static String[] extractNames( String line)
    {
        String[] names;

        //split the words separated by spaces
        names = line.split("\\s+");

        //remove last char, the comma, from the last name
        names[0] = names[0].substring(0, names[0].length() - 1);

        return names;
    }

    public static String printNames(ArrayList<Map<String, String>> employees, int numNames) {
        StringBuilder builder = new StringBuilder();

        String first, last, name;

        builder.append("Total of " + numNames + " names");
        builder.append("\n---------------------\n");

        for (int a = 0; a < numNames; a++) {
            first = employees.get(a).get("First Name");
            last = employees.get(a).get("Last Name");
            name = last + ", " + first;

            builder.append(name).append("\n");

        }

        return builder.toString();
    }

    private static void printFile(String output)
    {
        try {
            BufferedWriter bw = new BufferedWriter( new FileWriter( "exercise41_output.txt" ));
            bw.write(output);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}