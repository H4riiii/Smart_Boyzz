import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "PTA_MNGMNT_SYSTEM";
    private static String USER;
    private static String PASS;

    public DBConnection(String USER, String PASS){
        DBConnection.USER = USER;
        DBConnection.PASS = PASS;
    }

    public Connection getConnection(){
        try{
            try(Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = con.createStatement()){
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            }
            return DriverManager.getConnection(URL + DB_NAME, USER, PASS);
        } catch (SQLException e){
            if(e.getErrorCode() == 1045){
                System.out.println("ERROR : Invalid Username or Password!!! TRY AGAIN!!!");
            }
            else{
                System.out.println("Database error : " + e.getMessage());
            }
            return null;
        }
    }

}
