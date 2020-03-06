package demos.gui.uicomponents;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.utils.JFXHighlighter;
import com.jfoenix.utils.JFXNodeUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class HighlighterController implements Initializable {

    @FXML
    private JFXTextField searchField;
    @FXML
    private Pane content;

    private JFXHighlighter highlighter = new JFXHighlighter();

    /**
     * init fxml when loaded.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JFXDepthManager.setDepth(content, 1);
        JFXNodeUtils.addDelayedEventHandler(searchField, Duration.millis(400),
            KeyEvent.KEY_PRESSED, event -> highlighter.highlight(content, searchField.getText()));
    }

}
