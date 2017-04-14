#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;




public class Main {
    private static final int FILE_SIZE = 20;
    private static final int MAX_STRING_LENGTH = 50;

    private static List<Tokenizer> str = new ArrayList<>();


    public static void main(String[] args) throws IOException

    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the file name");
        String fileName = reader.readLine();
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String temp;
        int lineNumber = 0;
        while ((temp = bf.readLine()) != null) {
            Tokenizer.tokenize(temp, lineNumber, fileName, str);
            lineNumber++;
        }
        Indexator.createIndex(str);


    }
}

