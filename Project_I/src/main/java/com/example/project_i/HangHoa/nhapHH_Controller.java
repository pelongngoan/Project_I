package com.example.project_i.HangHoa;

import com.example.project_i.KetNoi_Database.DBConnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class nhapHH_Controller {

    @FXML
    private TextField donViTinh_Label;

    @FXML
    private TextField giaBanLe_Label;

    @FXML
    private TextField giaNhap_Label;

    @FXML
    private TextField giaXuat_Label;

    @FXML
    private TextField maHH_Label;

    @FXML
    private TextField nhomHH_Label;

    @FXML
    private TextField tenHH_Label;

    @FXML
    private AnchorPane themForm;

    @FXML
    private AnchorPane back_Form;

    public Connection conn = null ;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;
    ObservableList<HangHoa_Module> products_Data;

    @FXML
    void saveButton() {
        conn = DBConnection.ConnectionDB();
        String sql = "INSERT INTO danhMucHH(maHang, tenHang, donViTinh, giaNhap, giaXuat, giaBanLe) VALUES (?,?,?,?,?,?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(maHH_Label.getText()));
            preparedStatement.setString(2, tenHH_Label.getText());
            preparedStatement.setString(3, donViTinh_Label.getText());
            preparedStatement.setDouble(4, Double.parseDouble(giaNhap_Label.getText()));
            preparedStatement.setDouble(5, Double.parseDouble(giaXuat_Label.getText()));
            preparedStatement.setDouble(6, Double.parseDouble(giaBanLe_Label.getText()));
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "ADD");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        maHH_Label.clear();
        tenHH_Label.clear();
        donViTinh_Label.clear();
        giaNhap_Label.clear();
        giaXuat_Label.clear();
        giaBanLe_Label.clear();
        themForm.setVisible(false);

    }

}
