package com.example.project_i.TrangChu;

import com.example.project_i.FXML_Loader;
import com.example.project_i.HangHoa.HangHoa_Module;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private MenuItem nhapHDBL_MenuItem;

    @FXML
    private MenuItem nhapPC_MenuItem;

    @FXML
    private MenuItem nhapPN_MenuItem;

    @FXML
    private MenuItem nhapPT_MenuItem;

    @FXML
    private MenuItem nhapPX_MenuItem;

    @FXML
    private MenuItem quanLyHH_MenuItem;

    @FXML
    private MenuItem quanLyKH_MenuItem;

    @FXML
    private BorderPane mainPane;

   /* public void switchQuanLyHH(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/com/example/project_i/HangHoa/quanLyHH_Form.fxml").toURI().toURL();
        AnchorPane view = FXMLLoader.load(url);
        mainPane.setCenter(view);
    }*/

    public void switchForm(ActionEvent event) throws IOException {
        URL url = null;
        if (event.getSource() == quanLyHH_MenuItem) {
            url = new File("src/main/resources/com/example/project_i/HangHoa/quanLyHH_Form.fxml").toURI().toURL();
        } else if (event.getSource() == quanLyKH_MenuItem) {
            url = new File("src/main/resources/com/example/project_i/KhachHang/quanLyKH_Form.fxml").toURI().toURL();
        } else if (event.getSource() == nhapHDBL_MenuItem) {
            url = new File("src/main/resources/com/example/project_i/hoaDonBL_Form.fxml").toURI().toURL();
        } else if (event.getSource() == nhapPN_MenuItem) {
            url = new File("src/main/resources/com/example/project_i/PhieuNhap/phieuNhap_Form.fxml").toURI().toURL();
        } else if (event.getSource() == nhapPX_MenuItem) {
            url = new File("src/main/resources/com/example/project_i/PhieuXuat/phieuXuat_Form.fxml").toURI().toURL();
        } else if (event.getSource() == nhapPT_MenuItem) {
            url = new File("src/main/resources/com/example/project_i/PhieuThu/phieuThu_Form.fxml").toURI().toURL();
        } else if (event.getSource() == nhapPC_MenuItem) {
            url = new File("src/main/resources/com/example/project_i/PhieuChi/phieuChi_Form.fxml").toURI().toURL();
        }
        AnchorPane view = FXMLLoader.load(url);
        mainPane.setCenter(view);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}
