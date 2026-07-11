import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader (
            getClass().getResource("/view/registro.fxml")
        );

        Scene scene = new Scene(loader.load());

        stage.setTitle("Sistema de Registro de Paquetes y Destinos");
        stage.setScene(scene);
        stage.setWidth(600);
        stage.setHeight(600);
        stage.show();
    }
}
