#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.sql.*;
import java.util.List;


public class Indexator {
    private static final String url = "jdbc:postgresql://localhost:5432/test";
    private static final String user = "postgres";
    private static final String password = "admin";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void createIndex(List<Tokenizer> list){
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            for (Tokenizer k : list) {
                stmt.executeUpdate("INSERT INTO indexator ( word, line_number,begin,edge,doc_name)${symbol_escape}n" +
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
