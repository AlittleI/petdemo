package org.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PetpalsApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("petpals.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // 第一个 SplitPane
        SplitPane mySplitPane = (SplitPane) root.lookup("#mySplitPane");
        if (mySplitPane != null) {
            final double fixedPosition = 0.28;
            mySplitPane.setDividerPositions(fixedPosition);
            mySplitPane.getDividers().get(0).positionProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal.doubleValue() != fixedPosition) {
                    mySplitPane.setDividerPositions(fixedPosition);
                }
            });
        }

        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.setMaxWidth(600);
        stage.setMaxHeight(400);
        stage.setTitle("Petpals");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
