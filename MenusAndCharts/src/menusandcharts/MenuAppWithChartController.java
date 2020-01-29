package menusandcharts;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author spangsberg
 */
public class MenuAppWithChartController implements Initializable {

    @FXML
    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleShowBarChart();
    }

    /**
     *  Displays the Bar Chart
     */
    @FXML
    private void handleShowBarChart() {

        borderPane.setCenter(buildBarChart());
    }

    /**
     *  Displays the Pie Chart
     */
    @FXML
    private void handleShowPieChart() {
        borderPane.setCenter(buildPieChart());
    }

    /**
     * Builds the Bar Chart UI component with demo data
     * 
     * @return 
     */
    private BarChart buildBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Product");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("quantity sold");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Products sold");

        dataSeries1.getData().add(new XYChart.Data("Product A", 3000));
        dataSeries1.getData().add(new XYChart.Data("Product B", 1000));
        dataSeries1.getData().add(new XYChart.Data("Product C", 150));
        
        barChart.getData().add(dataSeries1);
        barChart.setLegendVisible(false);
        
        return barChart;
    }

    /**
     * Builds the Pie Chart UI component with demo data
     * 
     * @return 
     */
    private PieChart buildPieChart() {

        //Preparing ObservbleList object         
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Product A", 3000),
                new PieChart.Data("Product B", 1000),                
                new PieChart.Data("Product C", 150));

        PieChart pieChart = new PieChart(pieChartData); //Creating a Pie chart      
        pieChart.setTitle("Products sold"); //Setting the title of the Pie chart 
        pieChart.setClockwise(true); //setting the direction to arrange the data 
        pieChart.setLabelLineLength(50); //Setting the length of the label line 
        pieChart.setLabelsVisible(true); //Setting the labels of the pie chart visible  
        pieChart.setStartAngle(180);

        ContextMenu contextMenu = new ContextMenu(); //create context menu
        MenuItem miSwitchToBarChart = new MenuItem("Switch to Bar Chart");
        contextMenu.getItems().add(miSwitchToBarChart);
        
        //Add event handler to display context menu
        pieChart.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getButton() == MouseButton.SECONDARY) {
                            contextMenu.show(pieChart, event.getScreenX(), event.getScreenY());
                        }                        
                    }
                });
               
        
        //Pre Java8
        //Add event handler to change chart type
        miSwitchToBarChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                borderPane.setCenter(buildBarChart());
                System.out.println("Handling with inner anonymous class");
            }
        }); 
        
        
        //Java8
        miSwitchToBarChart.setOnAction((ActionEvent event) -> { 
                borderPane.setCenter(buildBarChart());
                  System.out.println("Handling with lambda expression with typed input parameter");
       
        });
              
        return pieChart;
    }

    /**
     *  Event handler to close the application
     */
    @FXML
    private void handleClose() {
        System.exit(0);
    }
        
    /**
     *  Event handler to update the data in the Pie Chart
     */
    @FXML
    private void handleUpdatePieData() {
        Node node = borderPane.getCenter();
        
        if (node instanceof PieChart)
        {
            PieChart pc = (PieChart) node;
            double value = pc.getData().get(2).getPieValue();
            pc.getData().get(2).setPieValue(750);
        }
    }          
}
