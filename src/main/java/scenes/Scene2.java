package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

class Scene2 {
        private ArrayList<String> list = new ArrayList<>();

    void scene2(Stage stage) {
        VBox root = new VBox();
        root.setSpacing(10);
        Label label = new Label("Scene 2");
        Scene scene2 = new Scene(root, 800, 600);

        //set style
        Scene1.setStyle(root);

        //set buttons switcher scenes
        HBox buttonsScene = new HBox();
        Button buttonScene = new Button("To rooms list");
        buttonsScene.getChildren().addAll(buttonScene);

        //set text fields
        VBox textFields = new VBox();
        textFields.setSpacing(10);
        textFields.setAlignment(Pos.CENTER);
        TextField fieldRoom = new TextField();
        fieldRoom.setMaxWidth(500);
        fieldRoom.setText(list.get(0));
        TextField fieldName = new TextField();
        fieldName.setMaxWidth(500);
        fieldName.setText(list.get(1));
        TextField fieldEmail = new TextField();
        fieldEmail.setMaxWidth(500);
        fieldEmail.setText(list.get(2));
        TextField fieldDateFrom = new TextField();
        fieldDateFrom.setMaxWidth(500);
        fieldDateFrom.setText(list.get(3));
        TextField fieldDateTill = new TextField();
        fieldDateTill.setMaxWidth(500);
        fieldDateTill.setText(list.get(4));
        TextField fieldBreakfast = new TextField();
        fieldBreakfast.setMaxWidth(500);
        fieldBreakfast.setText(list.get(5));
        TextField fieldClear = new TextField();
        fieldClear.setMaxWidth(500);
        fieldClear.setText(list.get(6));
        TextField fieldDateRegistration = new TextField();
        fieldDateRegistration.setMaxWidth(500);
        fieldDateRegistration.setText(list.get(7));
        TextField fieldTotalCost = new TextField();
        fieldTotalCost.setMaxWidth(500);
        fieldTotalCost.setText(list.get(8));
        textFields.getChildren().addAll(label, fieldRoom, fieldName, fieldEmail, fieldDateFrom, fieldDateTill, fieldBreakfast, fieldClear, fieldDateRegistration, fieldTotalCost);

        buttonScene.setOnAction(e -> new Scene1().scene1(stage));//switch to scene1

        root.getChildren().addAll(buttonsScene, textFields);
        stage.setScene(scene2);
    }

    void setData(ArrayList<String> arrayList) {
        list = arrayList;
    }
}
