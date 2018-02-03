package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Austin Sizemore
 */
public class CheckerboardController extends CheckerboardStarter implements Initializable {
    
    private Stage stage;
    private Checkerboard checkerboard;
    //8 because that is the default for a board
    private int numRows = 8;
    private int numCols = 8;
    private double boardWidth;
    private double boardHeight;
   
    @FXML
    private VBox vBox;
    private AnchorPane anchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 

    //@Override
    public void start(Stage stage) {
        this.stage = stage;
        
        checkerboard = new Checkerboard(numRows, numCols, boardWidth, boardHeight);
        vBox.getChildren().add(checkerboard.getBoard());
               
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();   
     
        anchorPane = checkerboard.getBoard();
    }
    
    private void refresh() {
        checkerboard.build(stage.getWidth(), stage.getHeight());
    }
    
    private void clear() {
        checkerboard.clear();
    }

    @FXML
    private void blueSquares(){
        //clean up whatever exists first then inserting new desired color
        vBox.getChildren().remove(checkerboard.getBoard());
        //remake the board
        checkerboard = new Checkerboard(checkerboard.getNumRows(), checkerboard.getNumCols(), 60, 60, Color.SKYBLUE, Color.DARKBLUE);
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }

    @FXML
    private void redSquares(){
        //clean up whatever exists first then inserting new desired color
        vBox.getChildren().remove(checkerboard.getBoard());
        //remake the board
        checkerboard = new Checkerboard(checkerboard.getNumRows(), checkerboard.getNumCols(), 60, 60, Color.RED, Color.BLACK);
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }
    
    //In order of the menuitems from the menubar
    //will remove all items from the stage first no matter what
    //and then replace it with the desired board
    @FXML
    private void sixteenBySixteen(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(16, 16, 60, 60, checkerboard.getLightColor(), checkerboard.getDarkColor());
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }

    @FXML
    private void tenByTen(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(10, 10, 60, 60, checkerboard.getLightColor(), checkerboard.getDarkColor());
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }

    @FXML
    private void eightByEight(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(8, 8, 60, 60, checkerboard.getLightColor(), checkerboard.getDarkColor());
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }

    @FXML
    private void threeByThree(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(3, 3, 60, 60, checkerboard.getLightColor(), checkerboard.getDarkColor());
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }
}