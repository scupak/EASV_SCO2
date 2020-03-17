/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author smsj
 */
public class DBConnection {
    public final static String DB_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public final static String DB_URL = "jdbc:sqlserver://10.176.111.31;databaseName=UserDB42";
    //public final static String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=UserDB";
    
    public final static String DB_USERNAME = "smsj";
    public final static String DB_PASSWORD = "easv_smsj";

    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {        
     
        Connection conn = null;
        Class.forName(DB_DRIVER_CLASS);
        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        return conn;
    }
}
