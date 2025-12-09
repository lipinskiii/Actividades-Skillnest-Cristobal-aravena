package com.organization.features.home;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.organization.core.Navigation;

public class HomeController {

    @FXML
    private Button btnTasks;

    @FXML
    private void handleGoToTasks() {
        Navigation.goTo("/views/tasks/tasks-list.fxml");
    }
}
