import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hotel Booking");
        VBox rood = new VBox();
        rood.setAlignment(Pos.CENTER);

        TextField fieldName = new TextField();
        fieldName.setMaxWidth(300);
        fieldName.setPromptText("Enter name");
        TextField fieldEmail = new TextField();
        fieldEmail.setMaxWidth(300);
        fieldEmail.setPromptText("Enter email");

        ArrayList<String> arrayList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader("src/main/resources/list.txt"))){
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextLine());
            }

        }catch (IOException e){e.printStackTrace();}

        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList (arrayList);
        list.setItems(items);

        list.setMaxWidth(300);
        list.setMaxHeight(70);

        Button button = new Button("set");

        Label label = new Label();
        Scene scene = new Scene(rood, 800, 600);

        Separator separator = new Separator();
        separator.setMaxWidth(300);

        rood.getChildren().addAll(label, list, fieldName, fieldEmail, separator, button);

        stage.setScene(scene);
        stage.show();
    }
}
