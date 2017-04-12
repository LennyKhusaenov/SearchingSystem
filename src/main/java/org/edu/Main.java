package org.edu;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private static final int FILE_SIZE = 20;
    private static final int MAX_STRING_LENGTH = 50;
    private static final String url = "jdbc:postgresql://localhost:5432/test";
    private static final String user = "postgres";
    private static final String password = "admin";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static List<Tokenizer> str = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException, IOException

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
        System.out.println();
        for (Tokenizer k : str) System.out.println(k);


        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            for (Tokenizer k : str) {
                stmt.executeUpdate("INSERT INTO indexator ( word, line_number,begin,edge,doc_name)\n" +
                        " VALUES ('" + k.getWord() + "'," + k.getLineNumber() + "," + k.getStartIndex() + ","
                        + k.getEndIndex() + ",'" + k.getDocName() + "');");
            }


        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
//            try {
//                rs.close();
//            } catch (SQLException se) { /*can't do anything */ }
        }
    }
}

