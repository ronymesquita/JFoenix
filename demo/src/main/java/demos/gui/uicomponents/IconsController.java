package demos.gui.uicomponents;

import com.jfoenix.controls.*;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class IconsController implements Initializable {

    @FXML
    private JFXHamburger burger1;
    @FXML
    private JFXHamburger burger2;
    @FXML
    private JFXHamburger burger3;
    @FXML
    private JFXHamburger burger4;

    @FXML
    private JFXBadge badge1;

    @FXML
    private StackPane root;
    private JFXSnackbar snackbar;
    private int count = 1;


    /**
     * init fxml when loaded.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bindAction(burger1);
        bindAction(burger2);
        bindAction(burger3);
        bindAction(burger4);

        snackbar = new JFXSnackbar(root);
        snackbar.setPrefWidth(300);

        badge1.setOnMouseClicked((click) -> {
            int value = Integer.parseInt(badge1.getText());
            if (click.getButton() == MouseButton.PRIMARY) {
                value++;
            } else if (click.getButton() == MouseButton.SECONDARY) {
                value--;
            }

            if (value == 0) {
                badge1.setEnabled(false);
            } else {
                badge1.setEnabled(true);
            }
            badge1.setText(String.valueOf(value));

            // trigger snackbar
            if (count++ % 2 == 0) {
                snackbar.fireEvent(new SnackbarEvent(new JFXSnackbarLayout("Toast Message " + count)));
            } else {
                if (count % 4 == 0) {
                    JFXButton button = new JFXButton("CLOSE");
                    button.setOnAction(action -> snackbar.close());
                    snackbar.fireEvent(new SnackbarEvent(
                        new JFXSnackbarLayout("Snackbar Message Persistent " + count, "CLOSE", action -> snackbar.close()),
                        Duration.INDEFINITE, null));

                } else {
                    snackbar.fireEvent(new SnackbarEvent(
                        new JFXSnackbarLayout("Snackbar Message" + count, "UNDO", null),
                        Duration.millis(3000), null));
                }
            }
        });
    }

    private void bindAction(JFXHamburger burger) {
        burger.setOnMouseClicked((e) -> {
            final Transition burgerAnimation = burger.getAnimation();
            burgerAnimation.setRate(burgerAnimation.getRate() * -1);
            burgerAnimation.play();
        });
    }

}
