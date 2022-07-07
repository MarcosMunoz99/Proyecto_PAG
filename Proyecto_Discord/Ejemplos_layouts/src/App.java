import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox Vbox1= new VBox();
        for (int i = 0; i <= 10; i++) {
            Vbox1.getChildren().addAll(new Button("Button"+(int)(i+1)));
        }

        VBox Vbox2= new VBox();
        for (int i = 0; i <= 10; i++) {
            Vbox2.getChildren().addAll(new Button("Button"+(int)(i+1)));
        }

        HBox hBox = new HBox();
        hBox.getChildren().addAll(Vbox1,Vbox2);


        AnchorPane sAnchorPane = new AnchorPane();

        sAnchorPane.getChildren().addAll(hBox);
        
        Scene scene = new Scene(sAnchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
