package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Austin Sizemore
 */
public class CheckerboardStarter extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkerboard.fxml"));
        Parent root = loader.load();
        checkerboard.CheckerboardStarter controller = loader.getController();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        controller.start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
