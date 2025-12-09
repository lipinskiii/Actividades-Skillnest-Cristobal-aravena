package com.organization;

import com.organization.config.DatabaseConfig;
import com.organization.core.Navigation;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Navigation.setStage(stage);
        Navigation.goTo("/views/home/home.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}
