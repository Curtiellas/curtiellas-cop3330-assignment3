package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 luis curtiellas
 */

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ProductSearch
{
    public static void main( String[] args )
    {
        Header header = extractJSON();

        while (true)
        {
            System.out.print("What is the product name? ");
            String prod = getString();

            int found = Header.searchProduct(prod, header.getProducts().length, header.getProducts());

            if ( found >= 0 ) {
                header.printOutput(found);
                break;
            }

            else {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
    }

    public static Header extractJSON () {
        Header header = null;

        try {
            //Create a new Gson object
            Gson gson = new Gson();

            //Read the .json file
            BufferedReader br = new BufferedReader (new FileReader("exercise44_input.json"));

            //convert the .json info to Java object class Header
            header = gson.fromJson(br, Header.class);

            //Printing the .jason Details
            /*
            for (int a = 0; a < header.products.length; a++) {
                System.out.println("Name    : "+ header.getProducts(a).getName() );
                System.out.println("Price   : "+ header.getProducts(a).getPrice() );
                System.out.println("Quantity: "+ header.getProducts(a).getQuantity() );
            }
            */
        } catch (IOException e) {
            e.printStackTrace();
        }

        return header;
    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
