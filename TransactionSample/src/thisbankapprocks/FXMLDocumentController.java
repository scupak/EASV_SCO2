/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thisbankapprocks;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 *
 * @author smsj
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button txtDynamicSQL;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
        String connectionString = "jdbc:sqlserver://;database=;user=;password=";
        
        //Initialize DB objects
        Connection conn = null;        
        PreparedStatement withdrawMoney = null;
        PreparedStatement depositMoney = null;
        
        //Create helper SQL vars
        String withdrawMoneySQL = "UPDATE BankAccount SET Balance = Balance - ?, Holder=? WHERE AccountID = ?";
        String depositMoneySQL = "UPDATE BankAccount SET Balance = Balance + ?, Holder=? WHERE AccountID = ?";
        
        try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //use SQL Server JDBC driver
            conn = DriverManager.getConnection(connectionString);
            
            //Tell SQL Server not to auto-commit all statements - we have to do this manually
            conn.setAutoCommit(false); 
           
            //SQL statement #1
            withdrawMoney = conn.prepareStatement(withdrawMoneySQL);
            withdrawMoney.setDouble(1, 1000);
            withdrawMoney.setString(2, "Short");
            withdrawMoney.setInt(3, 1);
            withdrawMoney.executeUpdate();          
            
            //SQL statement #2
            depositMoney = conn.prepareStatement(depositMoneySQL);
            depositMoney.setDouble(1, 1000);
            
            //exceeding maximum nvarchar(10) limit --> SQL Exception
            //will cause rollback in catch clause
            depositMoney.setString(2, "Reeeeaaaaallllyy long holder name");
            //depositMoney.setString(2, "Bilbo"); //no exception
            
            depositMoney.setInt(3, 2);  
            depositMoney.executeUpdate();
            
            //if we are here, it means no exceptions and we can commit the updates
            conn.commit();
            System.out.println("Transaction committed succesfully");
        } 
        catch (SQLException e) 
        {
            if (conn != null) {
                System.out.println("Rolling back updates...");
                conn.rollback(); //an exception happened in executing the statements
            }              
            e.printStackTrace();
        }          
        finally
        {   
            if (conn != null) {
                conn.setAutoCommit(true); //set default again (will actually commit the last transaction)
                conn.close(); //close the connection --> if no conn.commit() it will rollback
            }                
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }        
}