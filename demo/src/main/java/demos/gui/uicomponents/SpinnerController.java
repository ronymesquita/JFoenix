package demos.gui.uicomponents;

import com.jfoenix.controls.JFXSpinner;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SpinnerController implements Initializable {

    @FXML
    private JFXSpinner blueSpinner;
    @FXML
    private JFXSpinner greenSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline timeline = new Timeline(
            new KeyFrame(
                Duration.ZERO,
                new KeyValue(blueSpinner.progressProperty(), 0),
                new KeyValue(greenSpinner.progressProperty(), 0)
            ),
            new KeyFrame(
                Duration.seconds(0.5),
                new KeyValue(greenSpinner.progressProperty(), 0.5)
            ),
            new KeyFrame(
                Duration.seconds(2),
                new KeyValue(blueSpinner.progressProperty(), 1),
                new KeyValue(greenSpinner.progressProperty(), 1)
            )
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


}
