import java.util.List;

import dominio.Contact;
import dominio.Mensaje;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import repository.MessageRepository;

public class VentanaPrincipal extends Application {

    public int User = 0;
    public int contact = 2;

    MessageRepository messageRepository = new MessageRepository();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // EL SCROLL DE CONTACTOS CREADO POR MODELO DE CONTACT EN EL CUAL ESTAN LOS
        // NOMBRES Y SUS MENSAJES
        ScrollPane scrollPane2 = new ScrollPane();
        scrollPane2.setVbarPolicy(ScrollBarPolicy.ALWAYS);

        scrollPane2.setMaxWidth(350);
        scrollPane2.setMinWidth(300);
        scrollPane2.setMaxHeight(600);

        VBox vBox2 = new VBox(10);
        vBox2.setStyle("-fx-background-color: #111B21");
        vBox2.setMaxWidth(350);
        scrollPane2.setContent(vBox2);

        vBox2.setPadding(new Insets(10));

        // LA LISTA DE CONTACTOS RECORRIDAS PARA MOSTRAR EN LA PANTALLA, NO ES CREADA
        // SINO RECORRIDA
        List<Contact> res = messageRepository.getContact(contact);

        for (Contact usr : res) {

            Image image = new Image(getClass().getResourceAsStream("./Images/Armando.png"));
            Image image2 = new Image(getClass().getResourceAsStream("./Images/Luis.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);

            FlowPane flowPane2 = new FlowPane();
            flowPane2.setMaxWidth(300);
            flowPane2.setStyle("-fx-background-color: #E9E7DD");

            Label lblName = new Label(usr.getNombreContact());
            lblName.setPadding(new Insets(0, 0, 0, 50));

            // SE INTENTO EL METODO DE BUSCAR POR NOMBNRE, PERO LUEGO SE CAMBIO A INT, PERO
            // AUN ASI NO SE PUEDE RETORNAR EL VALOR PARA QUE CAMBIE EN EL RESTO DE
            // DEL PROYECTO
            flowPane2.setOnMouseClicked(event -> {
                String contact = String.valueOf(lblName.getText());
                System.out.print(contact);
            });

            if (usr.getNombreContact() == "Yo") {
                imageView.setImage(image2);

            }

            flowPane2.getChildren().addAll(imageView, lblName);
            vBox2.getChildren().add(flowPane2);
        }

        // LISTA DE MENSAJES TANTO DEL QUE ENVIA COMO DEL QUE RECIBE
        List<Mensaje> resultMe = messageRepository.getMessage(User, contact);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setMinWidth(1000);
        scrollPane.setMaxHeight(600);
        scrollPane.maxWidthProperty();

        VBox vBox = new VBox(50);
        vBox.setPadding(new Insets(12));

        System.out.print(User);

        for (Mensaje msg : resultMe) {
            FlowPane flowPane = new FlowPane(10, 10);
            flowPane.setPadding(new Insets(14));
            flowPane.setStyle("-fx-background-color: #111B21");

            Label lblMessage = new Label(msg.getContent());
            lblMessage.setPadding(new Insets(20, 0, 0, 0));
            lblMessage.setStyle("-fx-text-fill: #E9E7DD");

            flowPane.getChildren().addAll(lblMessage);
            vBox.getChildren().add(flowPane);

        }

        VBox vBox3 = new VBox(100);
        vBox3.setPadding(new Insets(50, 12, 12, 12));

        List<Mensaje> resultSend = messageRepository.getMessage(2, 0);

        for (Mensaje msg : resultSend) {
            Image image1 = new Image(getClass().getResourceAsStream("./Images/Luis.png"));
            ImageView imageView = new ImageView(image1);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            FlowPane flowPane = new FlowPane(10, 10);
            flowPane.setPadding(new Insets(14));
            flowPane.setStyle("-fx-background-color: #005C4B");

            Label lblMessage = new Label(msg.getContent());
            lblMessage.setPadding(new Insets(20, 0, 0, 0));
            lblMessage.setStyle("-fx-text-fill: #E9E7DD");

            flowPane.getChildren().addAll(imageView, lblMessage);
            vBox3.getChildren().add(flowPane);

        }

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, vBox3);

        AnchorPane mAnchorPane = new AnchorPane();
        mAnchorPane.getChildren().add(hBox);

        scrollPane.setContent(mAnchorPane);

        // PARTE DEL INPUT DONDE SE ENVIAN LOS MENSAJES PARA LAS MENSAJERIAS
        FlowPane flowPane = new FlowPane(50, 50);
        TextField input = new TextField();
        flowPane.setStyle("-fx-background-color: #008287");
        flowPane.setPadding(new Insets(11, 0, 11, 400));
        input.setPadding(new Insets(5, 600, 5, 0));
        input.setStyle("-fx-background-color: #A9D9D0");
        input.setPromptText("Escribe un mensaje aqui");
        Button btn = new Button("Enviar");
        btn.setPadding(new Insets(8));
        btn.setStyle("-fx-background-color: #FFFFFF");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Image image1 = new Image(getClass().getResourceAsStream("./Images/Luis.png"));
                ImageView imageView = new ImageView(image1);
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                FlowPane flowPane = new FlowPane(10, 10);
                flowPane.setPadding(new Insets(14));
                flowPane.setStyle("-fx-background-color: #005C4B");
                Label lblMessage = new Label(input.getText());
                lblMessage.setStyle("-fx-text-fill: #E9E7DD");

                flowPane.getChildren().add(imageView);
                flowPane.getChildren().add(lblMessage);
                vBox3.getChildren().add(flowPane);
            }
        });

        flowPane.getChildren().addAll(input, btn);

        // USANDO UN FLOWPANE PARA LA PARTE DE ARRIBA
        FlowPane ftop = new FlowPane();
        ftop.setHgap(160.0);
        ftop.setStyle("-fx-background-color: #202C33");

        Label lContact = new Label("Contactos");
        lContact.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        lContact.setStyle("-fx-text-fill: #E9E7DD");
        lContact.setPadding(new Insets(10));

        Image imgContacts = new Image(getClass().getResourceAsStream("./Images/mensaje.png"));
        ImageView imgContac = new ImageView(imgContacts);
        imgContac.setFitHeight(50);
        imgContac.setFitWidth(50);

        Label lContact2 = new Label("Marcos");
        lContact2.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        lContact2.setStyle("-fx-text-fill: #E9E7DD");
        lContact2.setPadding(new Insets(15, 590, 15, 0));
        Image imgContacts2 = new Image(getClass().getResourceAsStream("./Images/menu.png"));
        ImageView imgContac2 = new ImageView(imgContacts2);
        imgContac2.setFitHeight(50);
        imgContac2.setFitWidth(50);

        ftop.getChildren().addAll(lContact, imgContac, lContact2, imgContac2);

        BorderPane sBorderPane = new BorderPane();

        sBorderPane.setTop(ftop);
        sBorderPane.setLeft(scrollPane2);
        sBorderPane.setRight(scrollPane);
        sBorderPane.setBottom(flowPane);

        AnchorPane root = new AnchorPane();

        root.getChildren().addAll(sBorderPane);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FirstView");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
