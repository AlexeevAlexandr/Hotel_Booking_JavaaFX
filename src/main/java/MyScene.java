import javafx.application.Application;
import javafx.stage.Stage;

public class MyScene extends Application {

    @Override
    public void start(Stage stage) {
        new Scene1().scene1(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
