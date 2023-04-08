package employeefx;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main extends Application {
//    private List<Employee> employeeList;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Load data from file into employeeList
//        employeeList = EmployeeFile.readEmployees();
//
//        // Create text fields for displaying first employee's data
//        TextField idField = new TextField(Integer.toString(employeeList.get(0).getId()));
//        TextField nameField = new TextField(employeeList.get(0).getName());
//        TextField cityField = new TextField(employeeList.get(0).getCity());
//        TextField positionField = new TextField(employeeList.get(0).getPosition());
//
//        // Disable fields so they can't be edited
//        idField.setDisable(true);
//        nameField.setDisable(true);
//        cityField.setDisable(true);
//        positionField.setDisable(true);
//
//        // Create a grid to lay out the text fields
//        GridPane gridPane = new GridPane();
//        gridPane.addRow(0, new TextField("ID"), idField);
//        gridPane.addRow(1, new TextField("Name"), nameField);
//        gridPane.addRow(2, new TextField("City"), cityField);
//        gridPane.addRow(3, new TextField("Position"), positionField);
//
//        // Create a scene and add the grid to it
//        Scene scene = new Scene(gridPane, 400, 300);
//
//        // Set the stage's title and scene, and show the stage
//        primaryStage.setTitle("EmployeeFX");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//}