/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package preparedstatements;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author spangsberg
 */
public class MainController implements Initializable {
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws Exception {
        
        justNormalStatements();        
        //preparedStatements();
        //batchSample();
        
    }
    
    
    private void justNormalStatements() throws Exception {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        
        //FIXME: create connection string
        
        //Initialize DB objects
        Connection conn = null;        
        Statement stmt = null;
        
        try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //use SQL Server JDBC driver
            conn = DriverManager.getConnection(connectionString);
            
            //Dynamic, insecure SQL
            String sql = "SELECT * FROM [User] WHERE Username ='" + username + "' AND Password = '" + password + "'";
            
            stmt = conn.createStatement();
            
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            
            Boolean isLoggedIn = false;
            
            lblOutput.setText("");
            
            while (rs.next()) {
                isLoggedIn = true;
                
                String temp = lblOutput.getText();
                
                lblOutput.setText(temp + "\n" + rs.getString("Username"));
            }  
            
            if (!isLoggedIn) {
                lblOutput.setText("Not logged in...");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }          
        finally
        {   
            if (conn != null) { conn.close();  }
        } 
    }
    
    
    
    private void preparedStatements() throws Exception {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        
        //FIXME: create connection string
        
        //Initialize DB objects
        Connection conn = null;        
        PreparedStatement stmt = null;
        
        try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //use SQL Server JDBC driver
            conn = DriverManager.getConnection(connectionString);
            
            String sql = "SELECT * FROM [User] WHERE Username = ? AND Password = ?";
            
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
                      
            System.out.println(sql);
            
            Boolean isLoggedIn = false;
            
            lblOutput.setText("");
            
            while (rs.next()) {
                isLoggedIn = true;
                
                String temp = lblOutput.getText();
                
                lblOutput.setText(temp + "\n" + rs.getString("Username"));
            }  
            
            if (!isLoggedIn) {
                lblOutput.setText("Not logged in...");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }          
        finally
        {   
            if (conn != null) { conn.close();  }
        } 
    }
    
    
    
    private void batchSample() throws Exception {
        
        //FIXME: create connection string
        
        //Initialize DB objects
        Connection conn = null;        
        PreparedStatement stmt = null;
        
        try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //use SQL Server JDBC driver
            conn = DriverManager.getConnection(connectionString);
            
            stmt = conn.prepareStatement("INSERT INTO [User] VALUES (?,?)");

            for (int i = 0; i < 10000000; i++) {
                stmt.setString(1, "Username" + i);
                stmt.setString(2, "Password" + i);
                stmt.addBatch();
            }
            
            stmt.executeBatch();

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }          
        finally
        {   
            if (conn != null) { conn.close();  }
        } 
    }
}