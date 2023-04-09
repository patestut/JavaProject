package employeefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

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
//    private HBox hbox = new HBox();
//    private VBox vbox = new VBox();
//    private Pane pane = new Pane();
    
    @Override
    public void start(Stage stage) throws Exception {

        bntfirst.setOnAction((e) -> {
            String first = txtid.getText();
        });

        bntnext.setOnAction((e) -> {

        });

        bntprevious.setOnAction((e) -> {

        });

        bntlast.setOnAction((e) -> {

        });

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
        return pane;
    }
    

    public static void main(String[] args) {
        Application.launch(args);
    }

}

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
