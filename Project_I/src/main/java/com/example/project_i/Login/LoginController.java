package com.example.project_i.Login;

import com.example.project_i.FXML_Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField nameTexField;
    public TextField passwordTexField;
    public Pane pane;


    @FXML
    public void login(ActionEvent event) throws IOException {
        /*if(!nameTexField.getText().equals("long") || !passwordTexField.getText().equals("long")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Bạn nhập sai mật khẩu rồi ", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }*/

        URL url = new File("src/main/resources/com/example/project_i/TrangChu/MenuBar.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/TrangChu/MenuBar.fxml"));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
