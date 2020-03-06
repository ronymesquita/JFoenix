package demos.gui.uicomponents;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TextFieldController implements Initializable {

    @FXML
    private JFXTextField validatedText;
    @FXML
    private JFXPasswordField validatedPassword;
    @FXML
    private JFXTextArea jfxTextArea;

    /**
     * init fxml when loaded.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        validatedText.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatedText.validate();
            }
        });
        validatedPassword.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatedPassword.validate();
            }
        });
        jfxTextArea.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                jfxTextArea.validate();
            }
        });
    }

}
