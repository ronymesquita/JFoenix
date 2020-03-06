package demos.gui.uicomponents;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;


public class PickersController implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private JFXDatePicker dateOverlay;
    @FXML
    private JFXTimePicker timeOverlay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateOverlay.setDialogParent(root);
        timeOverlay.setDialogParent(root);
    }
}
