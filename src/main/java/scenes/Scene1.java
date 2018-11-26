package scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Scene1 {
    void scene1(Stage stage) {
        stage.setTitle("Hotel Booking");
        VBox root = new VBox();
        root.setSpacing(10);
        Label label = new Label("Scene 1");
        Scene scene = new Scene(root, 800, 600);

        //set style
        BackgroundImage myBI= new BackgroundImage(new Image("8M5A7719 edited.jpg",800,600,false,true),
                BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        //reading from file
        ArrayList<String> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader("src/main/resources/list.txt"))) {
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //view on window
        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(arrayList);
        list.setItems(items);
        list.setMaxWidth(500);
        list.setMaxHeight(200);

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
        textFields.getChildren().addAll(label, list, fieldName, fieldEmail);

        //set date fields
        HBox dateFields = new HBox();
        dateFields.setAlignment(Pos.CENTER);
        dateFields.setSpacing(100);
        DatePicker datePicker1 = new DatePicker();
        datePicker1.setPromptText("Enter date from");
        DatePicker datePicker2 = new DatePicker();
        datePicker2.setPromptText("Enter date till");
        dateFields.getChildren().addAll(datePicker1, datePicker2);

        //set buttons
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        Button buttonSet = new Button("set");
        Button buttonClear = new Button("clear");
        buttons.getChildren().addAll(buttonSet, buttonClear);

        //set radio buttons
        HBox radioButtons = new HBox();
        RadioButton radioClear = new RadioButton("Add clearing 1$");
        RadioButton radioBreakfast = new RadioButton("Add breakfast 2$");
        radioButtons.getChildren().addAll(radioClear, radioBreakfast);
        radioButtons.setSpacing(50);
        radioButtons.setAlignment(Pos.CENTER);

        root.getChildren().addAll(textFields, dateFields, radioButtons, buttons);
        stage.setScene(scene);
        stage.show();

        //event handling
        fieldDataClearing(buttonClear, fieldEmail, fieldName, datePicker1, datePicker2, radioBreakfast, radioClear);//field data clearing
        writeDataToListOrders(stage, buttonSet, fieldName, fieldEmail, datePicker1, datePicker2, radioBreakfast, radioClear);//field data setting
    }

    private void writeDataToListOrders(Stage stage, Button buttonSet, TextField fieldName, TextField fieldEmail, DatePicker datePicker1, DatePicker datePicker2, RadioButton radioBreakfast, RadioButton radioClear) {
        ArrayList<String> arrayList = new ArrayList<>();
        String dateRegistration = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        buttonSet.setOnAction(a -> {
            //write to file
            arrayList.add("Name = " + fieldName.getText() + "; ");
            arrayList.add("Email = " + fieldEmail.getText() + "; ");
            arrayList.add("Date from = " + datePicker1.getValue() + "; ");
            arrayList.add("Date Till = " + datePicker2.getValue() + "; ");
            arrayList.add("Breakfast = " + (radioBreakfast.isSelected()? "YES" : "NO") + "; ");
            arrayList.add("Clear = " + (radioClear.isSelected() ? "YES" : "NO") + "; ");
            arrayList.add("Date registration = " + dateRegistration);

            try (FileWriter writer = new FileWriter("src/main/resources/listOrders.txt", true)) {
                for (String o : arrayList) {
                    writer.write(o);
                }
                writer.write("\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene2 scene2 = new Scene2();
            scene2.setData(arrayList);
            scene2.scene2(stage);//switch to scene2
        });
    }

    private void fieldDataClearing(Button buttonClear, TextField fieldEmail, TextField fieldName, DatePicker datePicker1, DatePicker datePicker2, RadioButton radioBreakfast, RadioButton radioClear) {
        buttonClear.setOnAction(e ->
        {
            fieldEmail.clear();
            fieldName.clear();
            datePicker1.getEditor().clear();
            datePicker2.getEditor().clear();
            radioClear.setSelected(false);
            radioBreakfast.setSelected(false);
        });

    }
}
