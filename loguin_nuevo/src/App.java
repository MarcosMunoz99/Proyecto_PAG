import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class App extends Application {

			public static TextField text;
			public static PasswordField pwr;
			
			@Override
			public void start(Stage primaryStage) {
				try {
					
				
					VBox vbx = new VBox ();
					// imagen para el logui 
					Image imagen = new Image(getClass().getResourceAsStream("/Imagenes/Fondo.png"));
					ImageView vi = new ImageView(imagen);
					vi.setPreserveRatio(true);
					vi.setSmooth(true);
					vi.setCache(true);
					vbx.getChildren().add(vi);
					
					// sentencias para el loguin usuario y contraseña 
					VBox Vbox = new VBox();
					Vbox.setStyle("-fx-background-color: #85C1E9");
					
					VBox vbox = new VBox();
					vbox.setSpacing(40);
					Label lnl = new Label(" USUARIO :)");
					Font font = new Font("Times New Roman", 20);
					lnl.setFont(font);
					lnl.setTextFill(Color.BLACK);
					lnl.setAlignment(Pos.BASELINE_CENTER);
					TextField text = new TextField();
					Label lbl = new Label(" CONTRASEÑA :)");
					lbl.setFont(font);
					lbl.setTextFill(Color.BLACK);
					lbl.setAlignment(Pos.BASELINE_CENTER);
					PasswordField  pwr= new PasswordField();
					vbox.getChildren().addAll(lnl,text,lbl, pwr);
					Vbox.getChildren().add(vbox);

                    // Boton de aceptar y validacion de contraseña y usuario 

					Button btn = new Button(" ACEPTAR :) ");
					btn.setFont(font);
					btn.setTextFill(Color.BLACK);
					btn.setOnAction(new EventHandler<ActionEvent> () {
						@Override
						public void handle(ActionEvent arg0) {
						if(text.getText().equals("")||(pwr.getText().equals(""))){
						System.out.println("ingresar los datos");
					}else {
						if((text.getText().equals("Amanecer"))&&(pwr.getText().equals("admin"))) {
							System.out.println("ingreso acptado :) "); 
						}else {
							System.out.println("Error :( "); 
						}
					}
						}
				
					});
					btn.setStyle("-fx-background-color: orange;");
					Vbox.getChildren().add(btn);
					
							
					AnchorPane root  = new AnchorPane();
					root.getChildren().addAll(vbx, Vbox);
					
			
					AnchorPane.setBottomAnchor(vbx, 0.0);
					AnchorPane.setLeftAnchor(vbx, 0.0);
					AnchorPane.setRightAnchor(vbx,370.0);
					AnchorPane.setTopAnchor(vbx, 0.0);
					
					AnchorPane.setBottomAnchor(Vbox, 0.0);
		 	    	AnchorPane.setLeftAnchor(Vbox, 350.0);
					AnchorPane.setRightAnchor(Vbox, 0.0);
					AnchorPane.setTopAnchor(Vbox, 0.0);
					

					
					Scene scene = new Scene(root,700,350);
					primaryStage.setTitle(" WHATSAPP");
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
            }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
