import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("This is AppMain !!!");
        launch(args);
    }
}
