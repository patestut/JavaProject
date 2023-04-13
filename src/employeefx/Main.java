/**
 * Stuti Patel
 * 991663001
 * Treesa Saju
 * 991670853
 * Final Project
 * 11th April 2023
 */
package employeefx;

import content.Employee;
import content.EmployeeFile;
import content.SearchStage;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static Object getEmployeeManager() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Label lblid = new Label("ID");
    private Label lblname = new Label("Name");
    private Label lblcity = new Label("City");
    private Label lblposition = new Label("Position");
    private TextField txtid = new TextField();
    private TextField txtname = new TextField();
    private TextField txtcity = new TextField();
    private TextField txtposition = new TextField();
    private Button bntfirst = new Button("First");
    private Button bntnext = new Button("Next");
    private Button bntprevious = new Button("Previous");
    private Button bntlast = new Button("Last");
    private Button bntupdate = new Button("Update");
    private Button bntdelete = new Button("Delete");
    private Button bntadd = new Button("Add");
    private Button bntsearch = new Button("Search");
    SearchStage one = new SearchStage();

    private LinkedList<Employee> employeesList = EmployeeFile.readEmployees();
    private int i = 0;// declared i to call the element from the employeelist

    @Override
    public void start(Stage stage) throws Exception {

        bntfirst.setOnAction((e) -> getFirst());
        bntnext.setOnAction((e) -> getNext());
        bntprevious.setOnAction((e) -> getPrevious());
        bntlast.setOnAction((e) -> getLast());
        bntupdate.setOnAction((e) -> getUpdate());
        bntdelete.setOnAction((e) -> getDelete());
        bntadd.setOnAction((e) -> getAdd());
        bntsearch.setOnAction((e) -> getSearch());
        Scene scene = new Scene(getGrid(), 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    private GridPane getGrid() {
        GridPane pane = new GridPane();
        pane.add(lblid, 0, 0);
        pane.add(txtid, 1, 0);
        pane.add(lblname, 0, 1);
        pane.add(txtname, 1, 1);
        pane.add(lblcity, 0, 2);
        pane.add(txtcity, 1, 2);
        pane.add(lblposition, 0, 3);
        pane.add(txtposition, 1, 3);
        pane.add(bntfirst, 0, 4);
        pane.add(bntnext, 1, 4);
        pane.add(bntprevious, 2, 4);
        pane.add(bntlast, 3, 4);
        pane.add(bntupdate, 0, 5);
        pane.add(bntdelete, 1, 5);
        pane.add(bntadd, 2, 5);
        pane.add(bntsearch, 3, 5);
        return pane;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void getFirst() {
        if (!employeesList.isEmpty()) {
            i = 0;
            Details();
        }
    }

    private void getNext() {
        if (!employeesList.isEmpty()) {
            i = (i + 1) % employeesList.size();
            Details();
        }
    }

    private void getPrevious() {
        if (!employeesList.isEmpty()) {
            i = (i - 1 + employeesList.size()) % employeesList.size();
            Details();
        }
    }

    private void getLast() {
        if (!employeesList.isEmpty()) {
            i = employeesList.size() - 1;
            Details();
        }
    }

    private void Details() {
        if (!employeesList.isEmpty()) {
            Employee currentEmployee = employeesList.get(i);
            txtid.setText(String.valueOf(currentEmployee.getID()));
            txtname.setText(currentEmployee.getName());
            txtcity.setText(currentEmployee.getCity());
            txtposition.setText(currentEmployee.getPosition());
        }
    }

    public void getUpdate() {
        if (!employeesList.isEmpty()) {
            int id = Integer.parseInt(txtid.getText());
            String name = txtname.getText();
            String city = txtcity.getText();
            String position = txtposition.getText();
            Employee updatedEmployee = new Employee(id, name, city, position);
            employeesList.set(i, updatedEmployee);
            EmployeeFile.writeEmployees(employeesList);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Employee Updated");
            alert.setHeaderText(null);
            alert.setContentText("The employee was updated successfully!");
            alert.show();
        }
    }

    public void getDelete() {
        if (!employeesList.isEmpty()) {
            employeesList.remove(i);
            EmployeeFile.writeEmployees(employeesList);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Employee Deleted");
            alert.setHeaderText(null);
            alert.setContentText("Do you want to delete?");
            alert.setContentText("The employee was deleted successfully!");
            alert.show();
            if (employeesList.isEmpty()) {
                txtid.setText("");
                txtname.setText("");
                txtcity.setText("");
                txtposition.setText("");
            } else if (i == employeesList.size()) {
                i--;
                Details();
            } else {
                Details();
            }
        }
    }

    public void getAdd() {
        int id = Integer.parseInt(txtid.getText());
        String name = txtname.getText();
        String city = txtcity.getText();
        String position = txtposition.getText();
        Employee newEmployee = new Employee(id, name, city, position);
        employeesList.add(newEmployee);
        EmployeeFile.writeEmployees(employeesList);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Employee Added");
        alert.setHeaderText(null);
        alert.setContentText("The employee was added successfully!");
        alert.show();
    }

    private void getSearch() {
        
        }
}
