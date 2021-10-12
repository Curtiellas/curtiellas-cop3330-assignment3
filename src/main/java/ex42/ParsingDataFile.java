package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 luis curtiellas
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParsingDataFile
{
    public static void main( String[] args ) throws FileNotFoundException {
        ArrayList <Map <String, String>> employees = new ArrayList<>();

        //enter values to the list
        int numEmployees = readFile(employees);

        //print the sorted list
        System.out.println( printNames(employees, numEmployees) );

        System.out.println( "Bye World!" );
    }

    public static int readFile( ArrayList <Map <String, String>> employees ) throws FileNotFoundException {
        int numEmployees = 0;
        String line;
        String[] values = new String[3];

        //initializing the file scan tool
        File file = new File( "exercise42_input.txt" );
        Scanner sc = new Scanner(file);

        while ( sc.hasNextLine() )
        {
            numEmployees++;

            //read entire line
            line = sc.nextLine();

            //separate the 3 values in the line with custom parser
            values = extractNames(line);

            //add the 3 values to the list
            addToList(values[1], values[0], values[2], employees);
        }

        sc.close();

        return numEmployees;
    }

    public static String[] extractNames( String line)
    {
        String[] values = new String[3];

        int[] commas = findCommas(line);
        int comma1 = commas[0];
        int comma2 = commas[1];

        //split the words separated by commas
        values[0] = line.substring (0, comma1);             //last name
        values[1] = line.substring (comma1 + 1, comma2);    //first name
        values[2] = line.substring (comma2 + 1);            //salary

        return values;
    }

    public static int[] findCommas(String line)
    {
        char[] array = line.toCharArray();
        char comma = ',';
        int[] commas = {0, 0};

        //find where the commas are
        for (int a = 0; a < array.length; a++)
        {
            if ( array[a] == comma && commas[0] == 0 )
                commas[0] = a;

            else if ( array[a] == comma )
                commas[1] = a;
        }

        return commas;
    }

    public static void addToList(String firstName, String lastName, String salary, ArrayList <Map <String, String>> employees)
    {
        employees.add( Map.of ("First Name", firstName,
                "Last Name", lastName,
                "Salary", salary));
    }

    public static String printNames(ArrayList<Map<String, String>> employees, int numEmployees) {
        StringBuilder builder = new StringBuilder();

        String first, last, salary;

        builder.append("Last      First     Salary");
        builder.append("\n--------------------------\n");

        for (int a = 0; a < numEmployees; a++) {
            first = employees.get(a).get("First Name");
            last = employees.get(a).get("Last Name");
            salary = employees.get(a).get("Salary");

            builder.append(last);
            for (int i = last.length(); i < 10; i++) {
                builder.append(" ");
            }

            builder.append(first);
            for (int i = first.length(); i < 10; i++) {
                builder.append(" ");
            }

            builder.append(salary);
            for (int i = salary.length(); i < 10; i++) {
                builder.append(" ");
            }

            builder.append("\n");
        }

        return builder.toString();
    }
}
