package scenes;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Scene1 {
    private int costBreakfast = 2;
    private int costClearing = 1;
    private Text textException = new Text("");
    void scene1(Stage stage) {
        stage.setTitle("Hotel Booking");
        VBox root = new VBox();
        root.setSpacing(10);
        Label label = new Label("Rooms list");
        Scene scene = new Scene(root, 800, 600);

        //set textException move animation
        textException.setTextOrigin(VPos.TOP);
        textException.setFont(Font.font(20));
        Pane rootTextException = new Pane(textException);
        KeyValue initKeyValue = new KeyValue(textException.translateXProperty(), scene.getWidth());
        KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);
        KeyValue endKeyValue = new KeyValue(textException.translateXProperty(), -1.0 * textException.getLayoutBounds().getWidth());
        KeyFrame endFrame = new KeyFrame(Duration.seconds(7), endKeyValue);
        Timeline timeline = new Timeline(initFrame, endFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

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
        datePicker1.setPromptText("Enter arrival date");
        DatePicker datePicker2 = new DatePicker();
        datePicker2.setPromptText("Enter departure date");
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
        RadioButton radioClear = new RadioButton("Add clearing " + costClearing + "$");
        RadioButton radioBreakfast = new RadioButton("Add breakfast " + costBreakfast + "$");
        radioButtons.getChildren().addAll(radioClear, radioBreakfast);
        radioButtons.setSpacing(50);
        radioButtons.setAlignment(Pos.CENTER);

        root.getChildren().addAll(textFields, dateFields, radioButtons, buttons, rootTextException);
        stage.setScene(scene);
        stage.show();

        //event handling
        fieldDataClearing(buttonClear, list, fieldEmail, fieldName, datePicker1, datePicker2, radioBreakfast, radioClear);//field data clearing
        writeDataToListOrders(stage, list, buttonSet, fieldName, fieldEmail, datePicker1, datePicker2, radioBreakfast, radioClear);//field data setting
    }

    private void writeDataToListOrders(Stage stage, ListView<String> list, Button buttonSet, TextField fieldName, TextField fieldEmail, DatePicker datePicker1, DatePicker datePicker2, RadioButton radioBreakfast, RadioButton radioClear) {
        ArrayList<String> arrayList = new ArrayList<>();
        String dateRegistration = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        buttonSet.setOnAction(a -> {
            //check if data has been entered
            if (list.getSelectionModel().isEmpty()){ textException.setText("No number selected"); throw new IllegalArgumentException("No number selected"); }
            else if (fieldName.getText().length() == 0){ textException.setText("Enter name"); throw new IllegalArgumentException("Name not entered"); }
            else if (fieldEmail.getText().length() == 0){ textException.setText("Enter email"); throw new IllegalArgumentException("Email not entered"); }
            else if (datePicker1.getValue() == null){ textException.setText("Enter arrival date"); throw new IllegalArgumentException("Arrival date not entered"); }
            else if (datePicker2.getValue() == null){ textException.setText("Enter departure date"); throw new IllegalArgumentException("Departure date not entered"); }
            else if (datePicker1.getValue() != null && datePicker2.getValue() != null) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = simpleDateFormat.parse(datePicker1.getValue().toString());
                    Date date2 = simpleDateFormat.parse(datePicker2.getValue().toString());
                    int diff = (int) TimeUnit.DAYS.convert((date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS);

                    //checking if the days number is negative
                    if (diff <= 0) {
                        textException.setText("Incorrect date insertion, the number of days can not be negative or 0"); throw new IllegalArgumentException("Incorrect date insertion, the number of days can not be negative or 0");
                    } else {
                        arrayList.add("Room: " + list.getSelectionModel().getSelectedItem() + "; ");
                        arrayList.add("Name = " + fieldName.getText() + "; ");
                        arrayList.add("Email = " + fieldEmail.getText() + "; ");
                        arrayList.add("Arrival date = " + datePicker1.getValue() + "; ");
                        arrayList.add("Departure date = " + datePicker2.getValue() + "; ");
                        arrayList.add("Breakfast = " + (radioBreakfast.isSelected() ? "YES" : "NO") + "; ");
                        arrayList.add("Clear = " + (radioClear.isSelected() ? "YES" : "NO") + "; ");
                        arrayList.add("Registration Date  = " + dateRegistration);
                        arrayList.add("Total cost  = " + getTotalCost(list.getSelectionModel().getSelectedItem(), radioBreakfast, radioClear, diff) + "$");
                    }
                    try (FileWriter writer = new FileWriter("src/main/resources/listOrders.txt", true)) {
                        for (String o : arrayList) {
                            writer.write(o);
                        }
                        writer.write("\n");
                        writer.flush();
                        Scene2 scene2 = new Scene2();
                        scene2.setData(arrayList);
                        scene2.scene2(stage);//switch to scene2
                    } catch (IOException e) { e.printStackTrace(); }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            });
    }

    private int getTotalCost(String list, RadioButton radioBreakfast, RadioButton radioClear, int diff) {
        String[] cost = list.split("=");
        return (Integer.parseInt(cost[3].trim()) + (radioBreakfast.isSelected() ? costBreakfast : 0) + (radioClear.isSelected() ? costClearing : 0)) * diff;
    }

    private void fieldDataClearing(Button buttonClear, ListView<String> list, TextField fieldEmail, TextField fieldName, DatePicker datePicker1, DatePicker datePicker2, RadioButton radioBreakfast, RadioButton radioClear) {
        buttonClear.setOnAction(e ->
        {
            fieldEmail.clear();
            fieldName.clear();
            datePicker1.getEditor().clear();
            datePicker2.getEditor().clear();
            radioClear.setSelected(false);
            radioBreakfast.setSelected(false);
            list.getSelectionModel().clearSelection();
        });

    }
}
