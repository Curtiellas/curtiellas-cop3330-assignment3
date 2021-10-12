package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 luis curtiellas
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class WebsiteGenerator
{
    public static void main( String[] args )
    {
        //set the name and author, and JavaScript and CSS folder choice
        System.out.print("Site name: ");
        String name = getString();
        System.out.print("Author: ");
        String author = getString();
        System.out.print("Do you want a folder for JavaScript? ");
        String JS = getString();
        System.out.print("Do you want a folder for CSS? ");
        String CSS = getString();

        Website site = new Website(name, author, JS, CSS);

        //create folder
        File folder = Website.createFile("./website/" + site.getName());

        //create index.html file
        File html = Website.createFile("./website/" + site.getName() + "/index.html", 0);
        site.htmlWrite( html );

        //create JS folder
        File JSFolder = null;
        if (site.getJSFolder())
            JSFolder = Website.createFile( "./website/" + site.getName() + "/js" );

        //create CSS folder
        File CSSFolder = null;
        if (site.getCSSFolder())
            CSSFolder = Website.createFile( "./website/" + site.getName() + "/css/" );
    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}