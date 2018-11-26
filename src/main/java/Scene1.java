import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Scene1 {

    void scene1(Stage stage) {
        stage.setTitle("Hotel Booking");
        VBox rood = new VBox();
        rood.setAlignment(Pos.CENTER);
        rood.setSpacing(10);
        Label label = new Label("Scene 2");
        Scene scene1 = new Scene(rood, 800, 600);

        //reading from file
        ArrayList<String> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader("src/main/resources/list.txt"))){
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextLine());
            }
        }catch (IOException e){e.printStackTrace();}

        //view on window
        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList (arrayList);
        list.setItems(items);
        list.setMaxWidth(500);
        list.setMaxHeight(200);

        //set buttons switcher scenes
        HBox buttonsScene = new HBox();
        Button buttonScene = new Button("To scene 2");
        buttonsScene.setAlignment(Pos.TOP_LEFT);
        buttonsScene.getChildren().addAll(buttonScene);

        //set text fields
        TextField fieldName = new TextField();
        fieldName.setMaxWidth(500);
        fieldName.setPromptText("Enter name");
        TextField fieldEmail = new TextField();
        fieldEmail.setMaxWidth(500);
        fieldEmail.setPromptText("Enter email");

        //set date fields
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);
        DatePicker datePicker1 = new DatePicker();
        datePicker1.setPromptText("Enter date from");
        DatePicker datePicker2 = new DatePicker();
        datePicker2.setPromptText("Enter date till");
        hBox.getChildren().addAll(datePicker1, datePicker2);

        //set buttons
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        Button button1 = new Button("set");
        Button button2 = new Button("clear");
        buttons.getChildren().addAll(button1, button2);

        //set radio buttons
        RadioButton radioSweep = new RadioButton("Add clearing 1$");
        RadioButton radioSin = new RadioButton("Add breakfast 2$");
        HBox radioButtons = new HBox();
        radioButtons.getChildren().addAll(radioSweep, radioSin);
        radioButtons.setSpacing(50);
        radioButtons.setAlignment(Pos.CENTER);

        //set separators lines
        Separator separator1 = new Separator();
        separator1.setMaxWidth(500);
        Separator separator2 = new Separator();
        separator2.setMaxWidth(500);

        rood.getChildren().addAll(buttonsScene, label, list, separator1, fieldName, fieldEmail, hBox, radioButtons, separator2, buttons);
        stage.setScene(scene1);
        stage.show();

        buttonScene.setOnAction(e -> new Scene2().scene2(stage));
    }
}
