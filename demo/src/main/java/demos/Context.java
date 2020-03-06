package demos;

import com.jfoenix.controls.JFXDrawer;
import javafx.stage.Stage;

public class Context {

    private static Context instance;

    private Stage primaryStage;

    private JFXDrawer drawer;

    private Context(){}

    public static Context getInstance() {
        if ( instance == null) {
            instance = new Context();
        }

        return instance;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public JFXDrawer getDrawer() {
        return drawer;
    }

    public void setDrawer(JFXDrawer drawer) {
        this.drawer = drawer;
    }
}
