package demos.gui.sidemenu;

import com.jfoenix.controls.JFXListView;
import demos.gui.uicomponents.*;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class SideMenuController implements Initializable {
    @FXML
    private JFXListView<Label> sideList;

    private final ReadOnlyObjectWrapper<Label> selectedLabel = new ReadOnlyObjectWrapper<>();

    /**
     * Map that contains the path to the fxml path of each views
     */
    private Map<String, String> menuPath = new HashMap<String, String>();

    public ReadOnlyObjectProperty<Label> selectedLabelProperty() {
        return selectedLabel.getReadOnlyProperty() ;
    }

    public Label getSelectedLabel() {
        return selectedLabel.get();
    }

    /**
     * init fxml when loaded.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuPath.put("button", "/fxml/ui/Button.fxml");
        menuPath.put("checkbox", "/fxml/ui/Checkbox.fxml");
        menuPath.put("chipview", "/fxml/ui/ChipView.fxml");
        menuPath.put("combobox", "/fxml/ui/ComboBox.fxml");
        menuPath.put("dialogs", "/fxml/ui/Dialog.fxml");
        menuPath.put("highlighter", "/fxml/ui/Highlighter.fxml");
        menuPath.put("icons", "/fxml/ui/Icons.fxml");
        menuPath.put("listview", "/fxml/ui/ListView.fxml");
        menuPath.put("masonry", "/fxml/ui/Masonry.fxml");
        menuPath.put("nodeslist", "/fxml/ui/NodesList.fxml");
        menuPath.put("pickers", "/fxml/ui/Pickers.fxml");
        menuPath.put("popup", "/fxml/ui/Popup.fxml");
        menuPath.put("progressbar", "/fxml/ui/ProgressBar.fxml");
        menuPath.put("radiobutton", "/fxml/ui/RadioButton.fxml");
        menuPath.put("scrollpane", "/fxml/ui/ScrollPane.fxml");
        menuPath.put("slider", "/fxml/ui/Slider.fxml");
        menuPath.put("spinner", "/fxml/ui/Spinner.fxml");
        menuPath.put("svgloader", "/fxml/ui/SVGLoader.fxml");
        menuPath.put("textfield", "/fxml/ui/TextField.fxml");
        menuPath.put("togglebutton", "/fxml/ui/ToggleButton.fxml");
        menuPath.put("treetableview", "/fxml/ui/TreeTableView.fxml");
    }

    /**
     * Return the path associated with a component id
     * @return the path associated with a component id
     */
    public String getMenuPath(String id) {
        return this.menuPath.get(id);
    }

    public void loadComponent(MouseEvent mouseEvent) {
        Label selectedItem = sideList.getSelectionModel().getSelectedItem();
        this.selectedLabel.set(selectedItem);
    }
}
