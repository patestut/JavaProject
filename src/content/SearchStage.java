/**
 * Stuti Patel
 * 991663001
 * Treesa Saju
 * 991670853
 * Final Project
 * 12th April 2023
 */
package content;

import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SearchStage extends Stage {

    private Label lblcity = new Label("City");
    private Label lblposition = new Label("Position");
    private TextField txtcity = new TextField();
    private TextField txtposition = new TextField();
    private Button btnsearch = new Button("Search");
    private Button btncancel = new Button("Cancel");
    private ListView<String> listView = new ListView<>();
    private LinkedList<Employee> employeesList = EmployeeFile.readEmployees();
    private ObservableList<String> searchResults = FXCollections.observableArrayList();

    public SearchStage() {
        setTitle("Search Employee");
        btnsearch.setOnAction((e) -> searchEmployee());
        btncancel.setOnAction((e) -> closeSearchStage());

        GridPane pane = new GridPane();
        pane.add(lblcity, 0, 0);
        pane.add(txtcity, 1, 0);
        pane.add(lblposition, 0, 1);
        pane.add(txtposition, 1, 1);
        pane.add(btnsearch, 1, 2);
        pane.add(listView, 0, 4, 2, 1);
        GridPane.setMargin(btnsearch, new Insets(0, 0, 0, 10));
        Scene scene = new Scene(pane, 300, 300);
        setScene(scene);
    }

    private void searchEmployee() {
        String city = txtcity.getText().toLowerCase();
        String position = txtposition.getText().toLowerCase();
        searchResults.clear();
        for (Employee employee : employeesList) {
            if (employee.getCity().toLowerCase().contains(city)
                    && employee.getPosition().toLowerCase().contains(position)) {
                searchResults.add(employee.getID() + ": " + employee.getName());
            }
        }
        listView.setItems(searchResults);
    }

    private void closeSearchStage() {
        close();
    }

    public void showSearchStage() {
        txtcity.clear();
        txtposition.clear();
        searchResults.clear();
        listView.setItems(searchResults);
        show();
    }

    public int getSelectedEmployeeID() {
        String selectedEmployee = listView.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            int index = selectedEmployee.indexOf(':');
            if (index != -1) {
                String idStr = selectedEmployee.substring(0, index).trim();
                return Integer.parseInt(idStr);
            }
        }
        return -1;
    }
}
