import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Scene2 {

    private Scene scene2;

    void scene2(Stage stage) {
        Label label2 = new Label();
        VBox rood2 = new VBox();
        rood2.setAlignment(Pos.CENTER);
        rood2.setSpacing(10);
        scene2 = new Scene(rood2, 800, 600);

        //set text fields
        TextField fieldName2 = new TextField();
        fieldName2.setMaxWidth(500);
        fieldName2.setPromptText("Enter name");
        TextField fieldEmail2 = new TextField();
        fieldEmail2.setMaxWidth(500);
        fieldEmail2.setPromptText("Enter email");


        //set buttons switcher scenes
        HBox buttonsScene = new HBox();
        Button buttonScene = new Button("To scene 1");
        buttonsScene.setAlignment(Pos.TOP_LEFT);
        buttonsScene.getChildren().addAll(buttonScene);


        buttonScene.setOnAction(e -> new Scene1().scene1(stage));

        rood2.getChildren().addAll(buttonsScene, label2, fieldName2, fieldEmail2);
        stage.setScene(scene2);
    }

    Scene getScene(){
        VBox rood2 = new VBox();
        rood2.setAlignment(Pos.CENTER);
        rood2.setSpacing(10);
        scene2 = new Scene(rood2, 800, 600);
        return scene2;
    }
}
