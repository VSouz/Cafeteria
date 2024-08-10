package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class bancoDados{

    private static final String url = "jdbc:mysql://localhost:3306/cafeteria";
    private static final String user  = "root";
    private static  final  String password = "padrao1234";

    private static Connection conn;

    public static  Connection getbancoDados(){

    try{

        if (conn == null){
            conn = DriverManager.getConnection(url,user,password);
             return conn;}
         else {
             return conn;
         }}

    catch (SQLException e) {
        e.printStackTrace();
        return null;
        }
    }
}