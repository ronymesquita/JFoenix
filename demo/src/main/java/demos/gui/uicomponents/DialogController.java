package demos.gui.uicomponents;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.jfoenix.controls.JFXDialogLayout;
import demos.Context;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class DialogController implements Initializable {

    @FXML
    private JFXButton centerButton;
    @FXML
    private JFXButton topButton;
    @FXML
    private JFXButton rightButton;
    @FXML
    private JFXButton bottomButton;
    @FXML
    private JFXButton leftButton;
    @FXML
    private JFXButton acceptButton;
    @FXML
    private JFXButton alertButton;
    @FXML
    private StackPane root;
    @FXML
    private JFXDialog dialog;

    /**
     * init fxml when loaded.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.getChildren().remove(dialog);

        StackPane contentPane = (StackPane)Context.getInstance().getDrawer().getChildren().get(0);

        centerButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.CENTER);
            dialog.show(contentPane);
        });

        topButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.TOP);
            dialog.show(contentPane);
        });

        rightButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.RIGHT);
            dialog.show(contentPane);
        });

        bottomButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.BOTTOM);
            dialog.show(contentPane);
        });

        leftButton.setOnAction(action -> {
            dialog.setTransitionType(DialogTransition.LEFT);
            dialog.show(contentPane);
        });

        acceptButton.setOnAction(action -> dialog.close());

        alertButton.setOnAction(action -> {
            JFXAlert alert = new JFXAlert((Stage) alertButton.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("Modal Dialog using JFXAlert"));
            layout.setBody(new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit,"
                                     + " sed do eiusmod tempor incididunt ut labore et dolore magna"
                                     + " aliqua. Utenim ad minim veniam, quis nostrud exercitation"
                                     + " ullamco laboris nisi ut aliquip ex ea commodo consequat."));
            JFXButton closeButton = new JFXButton("ACCEPT");
            closeButton.getStyleClass().add("dialog-accept");
            closeButton.setOnAction(event -> alert.hideWithAnimation());
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        });
    }

}
