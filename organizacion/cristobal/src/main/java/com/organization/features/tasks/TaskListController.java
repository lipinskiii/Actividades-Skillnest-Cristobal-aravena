package com.organization.features.tasks;

import com.organization.features.tasks.exception.TaskException;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;

public class TaskListController {

    @FXML
    private TableView<Task> tableTasks;

    @FXML
    private TableColumn<Task, String> colTitle;

    @FXML
    private TableColumn<Task, String> colDate;

    @FXML
    private Button btnNew;

    private final TaskService service = new TaskService();

    @FXML
    public void initialize() {
        try {
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
            tableTasks.getItems().addAll(service.getAllTasks());
        } catch (TaskException e) {
            showError(e.getMessage());
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.showAndWait();
    }
}
