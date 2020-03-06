package demos.gui.main;

import com.jfoenix.controls.*;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import demos.Context;
import demos.MainDemo;
import demos.gui.sidemenu.SideMenuController;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public final class MainController implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private StackPane titleBurgerContainer;
    @FXML
    private JFXHamburger titleBurger;

    @FXML
    private StackPane optionsBurger;
    @FXML
    private JFXRippler optionsRippler;
    @FXML
    private JFXDrawer drawer;

    private JFXPopup toolbarPopup;

    /**
     * init fxml when loaded.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // init the title hamburger icon
        final JFXTooltip burgerTooltip = new JFXTooltip("Open drawer");

        drawer.setOnDrawerOpening(e -> {
            final Transition animation = titleBurger.getAnimation();
            burgerTooltip.setText("Close drawer");
            animation.setRate(1);
            animation.play();
        });
        drawer.setOnDrawerClosing(e -> {
            final Transition animation = titleBurger.getAnimation();
            burgerTooltip.setText("Open drawer");
            animation.setRate(-1);
            animation.play();
        });
        titleBurgerContainer.setOnMouseClicked(e -> {
            if (drawer.isClosed() || drawer.isClosing()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ui/popup/MainPopup.fxml"));
        loader.setController(new InputController());
        try {
            toolbarPopup = new JFXPopup(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        optionsBurger.setOnMouseClicked(e ->
            toolbarPopup.show(optionsBurger,
                PopupVPosition.TOP,
                PopupHPosition.RIGHT,
                -12,
                15));
        JFXTooltip.setVisibleDuration(Duration.millis(3000));
        JFXTooltip.install(titleBurgerContainer, burgerTooltip, Pos.BOTTOM_CENTER);

        try {
            FXMLLoader sideMenuLoader =  new FXMLLoader();
            StackPane sideMenu = sideMenuLoader.load(getClass().getResource("/fxml/SideMenu.fxml").openStream());
            SideMenuController sideMenuController = sideMenuLoader.getController();
            sideMenuController.selectedLabelProperty().addListener((obs, oldLabel, newLabel) -> {
                String contentPath = sideMenuController.getMenuPath(newLabel.getId());
                try {
                    StackPane content = FXMLLoader.load(getClass().getResource(contentPath));
                    drawer.setContent(content);
                    drawer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            // Load initial content
            StackPane content = FXMLLoader.load(getClass().getResource("/fxml/ui/Button.fxml"));
            drawer.setContent(content);
            drawer.setSidePane(sideMenu);
            Context.getInstance().setDrawer(drawer);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // create the inner flow and content
//        context = new ViewFlowContext();
//        // set the default controller
//        Flow innerFlow = new Flow(ButtonController.class);
//
//        final FlowHandler flowHandler = innerFlow.createHandler(context);
//        context.register("ContentFlowHandler", flowHandler);
//        context.register("ContentFlow", innerFlow);
//        final Duration containerAnimationDuration = Duration.millis(320);
//        drawer.setContent(flowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration, SWIPE_LEFT)));
//        context.register("ContentPane", drawer.getContent().get(0));
//
//        // side controller will add links to the content flow
//        Flow sideMenuFlow = new Flow(SideMenuController.class);
//        final FlowHandler sideMenuFlowHandler = sideMenuFlow.createHandler(context);
//        drawer.setSidePane(sideMenuFlowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration,
//            SWIPE_LEFT)));
    }

    public static final class InputController {
        @FXML
        private JFXListView<?> toolbarPopupList;

        // close application
        @FXML
        private void submit() {
            if (toolbarPopupList.getSelectionModel().getSelectedIndex() == 1) {
                Platform.exit();
            }
        }
    }
}
