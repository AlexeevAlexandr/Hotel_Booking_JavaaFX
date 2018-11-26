package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Scene2 {

    void scene2(Stage stage) {
        VBox rood = new VBox();
        rood.setSpacing(10);
        Label label = new Label("Scene 2");
        Scene scene2 = new Scene(rood, 800, 600);

        //set buttons switcher scenes
        HBox buttonsScene = new HBox();
        Button buttonScene = new Button("To scene 1");
        buttonsScene.getChildren().addAll(buttonScene);

        //set text fields
        VBox rood1 = new VBox();
        rood1.setSpacing(10);
        rood1.setAlignment(Pos.CENTER);
        TextField fieldName = new TextField();
        fieldName.setMaxWidth(500);
        fieldName.setPromptText("Enter name");
        TextField fieldEmail = new TextField();
        fieldEmail.setMaxWidth(500);
        fieldEmail.setPromptText("Enter email");
        rood1.getChildren().addAll(label, fieldName, fieldEmail);

        buttonScene.setOnAction(e -> new Scene1().scene1(stage));

        rood.getChildren().addAll(buttonsScene, rood1);
        stage.setScene(scene2);
    }
}
