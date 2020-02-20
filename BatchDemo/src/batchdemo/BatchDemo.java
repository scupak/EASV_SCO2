
package batchdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author smsj
 */
public class BatchDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO [User] VALUES (?,?)");
            
            for (int i = 0; i < 10000; i++) {
                stmt.setString(1, "Username" + i);
                stmt.setString(2, "Password" + i);
            
                stmt.addBatch();
                
                //stmt.executeUpdate();
            }
            
            stmt.executeBatch();
        }
        catch (Exception e) {
            e.printStackTrace();
        }        
    }    
}
