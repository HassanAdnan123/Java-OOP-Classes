import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {

        FileInputStream inputFile = null;
        FileOutputStream outputFile = null;
        try {
            inputFile = new FileInputStream("C:/Beg Java Stuff/myFile.txt");
        }
        catch(SecurityException e) {
            System.out.println("Problem: "+e.getMessage());
        }

    }
}