/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Bruno Barbosa
 */
public class BDConnect {
    
    private static Connection con;
    private static String url = "jdbc:postgresql://localhost:5432/Colegio";
    private static String user = "postgres";
    private static String pass = "postgres";
    
    public static Connection conect(){
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            a.show();
        }
        return con;
    }
    
    public static Connection getConnection() throws SQLException{
        if(con != null && !con.isClosed()){
            return con;
        }else{
            conect();
            return con;
        }
    }
}
