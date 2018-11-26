package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

class Scene2 {

    void scene2(Stage stage) {
        VBox root = new VBox();
        root.setSpacing(10);
        Label label = new Label("Scene 2");
        Scene scene2 = new Scene(root, 800, 600);

        //set style
        BackgroundImage myBI= new BackgroundImage(new Image("8M5A7719 edited.jpg",800,600,false,true),
                BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        //set buttons switcher scenes
        HBox buttonsScene = new HBox();
        Button buttonScene = new Button("To scene 1");
        buttonsScene.getChildren().addAll(buttonScene);

        //set text fields
        VBox textFields = new VBox();
        textFields.setSpacing(10);
        textFields.setAlignment(Pos.CENTER);
        TextField fieldName = new TextField();
        fieldName.setMaxWidth(500);
        fieldName.setPromptText("Enter name");
        TextField fieldEmail = new TextField();
        fieldEmail.setMaxWidth(500);
        fieldEmail.setPromptText("Enter email");
        textFields.getChildren().addAll(label, fieldName, fieldEmail);

        buttonScene.setOnAction(e -> new Scene1().scene1(stage));

        root.getChildren().addAll(buttonsScene, textFields);
        stage.setScene(scene2);
    }
}
