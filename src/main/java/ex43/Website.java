package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Website {
    private String name;
    private String author;
    private boolean JavaScriptFolder;
    private boolean CSSFolder;

    //default constructor
    public Website() {
        name = "UnknownName";
        author = "UnknownAuthor";
        JavaScriptFolder = false;
        CSSFolder = false;
    }

    //parameterized constructor
    public Website( String name, String author, String JSfolder, String CSSFolder) {
        this.name = name;
        this.author = author;

        //simplified form, set to true if y, set to false otherwise
        this.JavaScriptFolder = JSfolder.equalsIgnoreCase("y");
        this.CSSFolder = CSSFolder.equalsIgnoreCase("y");
    }

    //getters
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public boolean getJSFolder() {
        return JavaScriptFolder;
    }
    public boolean getCSSFolder() {
        return CSSFolder;
    }

    //create folder
    public static File createFile(String path) {
        try {
            File f = new File( path );

            if (!f.exists()) {
                f.mkdirs();
            }

            System.out.println("Created " + path);
            return f;

        } catch (Exception e) {
            System.out.println("There was a problem creating the new directory");
            e.printStackTrace();
        }

        //error scenario
        return null;
    }

    //create folder... but modified for HTML file creation (overload)
    public static File createFile(String path, int unused) {
        try {
            File f = new File( path );

            System.out.println("Created " + path);
            return f;

        } catch (Exception e) {
            System.out.println("There was a problem creating the new directory");
            e.printStackTrace();
        }

        //error scenario
        return null;
    }

    //writes to html file
    public void htmlWrite(File html) {
        String htmlCode = "<title> " + name + "</title>\n<meta> " + author + "</meta>\n";

        try {
            BufferedWriter writer = new BufferedWriter( new FileWriter(html) );

            writer.write(htmlCode);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
