package com.organization.features.tasks;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import com.organization.core.Navigation;
import java.util.List;

public class TaskListController {

    @FXML
    private TableView<Task> tableTasks;

    @FXML
    private TableColumn<Task, String> colTitle;

    @FXML
    private TableColumn<Task, String> colDescription;

    @FXML
    private TableColumn<Task, String> colDueDate;

    @FXML
    private TableColumn<Task, Boolean> colCompleted;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnBack;

    private final TaskService service = new TaskService();

    @FXML
    public void initialize() {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colCompleted.setCellValueFactory(new PropertyValueFactory<>("completed"));

        List<Task> tasks = service.getAllTasks();
        tableTasks.getItems().setAll(tasks);
    }

    @FXML
    private void handleNewTask() {
    }

    @FXML
    private void handleEditTask() {
    }

    @FXML
    private void handleDeleteTask() {
    }

    @FXML
    private void handleBackToHome() {
        Navigation.goTo("/views/home/home.fxml");
    }
}
