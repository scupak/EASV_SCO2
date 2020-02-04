/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfeonixexamples;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;  
import javafx.util.StringConverter;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private JFXTextField txtSomeInput;
    @FXML
    private JFXSlider slide;
    
    @FXML
    private JFXSlider slide2;
    
    @FXML
    private JFXTextField txtOther;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        label.setText("Start heavy task...");
        Thread t = new Thread(()->{
            simulateHardWork();
        });
        t.start();
        //System.out.println("You clicked me!");
        
        
    }
    
    private void simulateHardWork(){
        try {
            Thread.sleep(5000);
            
            /*
            Platform.runLater(()->{
                label.setText("Done working");
            });
            */
                
                
            Platform.runLater(new Runnable() 
            {
                public void run() 
                {
                    label.setText("Done working");
                }
            });
                       
            
        }
        catch (InterruptedException ex) {
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NumberValidator nv = new NumberValidator("Not number?");
        nv.setMessage("WRONG!");
        txtSomeInput.getValidators().add(nv);
        txtSomeInput.setText("");
        txtSomeInput.textProperty().addListener(
                (observable, oldValue, newValue) -> {
            txtSomeInput.validate();
            /*
            try{
                Double d = Double.parseDouble(newValue);
            }
            catch (NumberFormatException nfe)
            {
                txtSomeInput.setText(oldValue);
            }*/
        });
        
        slide2.valueProperty().addListener((observable, oldValue, newValue) -> {
            txtSomeInput.setText(newValue+"");
        });
        
        //txtSomeInput.textProperty().bind(txtOther.textProperty());
        //txtOther.textProperty().set("df");
        
        
        
        Bindings.bindBidirectional(
                txtOther.textProperty(), slide2.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number num) {
                return num.toString();
            }

            @Override
            public Number fromString(String string) {
                try{
                    Double d = Double.parseDouble(string);
                    return d;
                }
                catch (NumberFormatException nfe)
                {
                    return 0;
                }
            }
           
        });
        
    }    
    
}
