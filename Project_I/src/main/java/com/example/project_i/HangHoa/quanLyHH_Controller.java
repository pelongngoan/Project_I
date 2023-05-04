package com.example.project_i.HangHoa;

import com.example.project_i.KetNoi_Database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class quanLyHH_Controller implements Initializable {

    @FXML
    private TableColumn<HangHoa_Module, String> donViTinh_Col;

    @FXML
    private TableColumn<HangHoa_Module, Double> giaBanLe_Col;

    @FXML
    private TableColumn<HangHoa_Module, Double> giaNhap_Col;

    @FXML
    private TableColumn<HangHoa_Module, Double> giaXuat_Col;

    @FXML
    private TableColumn<HangHoa_Module, Integer> maHang_Col;

    @FXML
    private TableColumn<HangHoa_Module, String> phanLoai_Col;

    @FXML
    private TableView<HangHoa_Module> quanLyHH_Table;

    @FXML
    private TableColumn<HangHoa_Module, Integer> stt_HH_Col;

    @FXML
    private TableColumn<HangHoa_Module, String> tenHang_Col;

    @FXML
    private TableColumn<HangHoa_Module, Integer> tonKho_Col;

    @FXML
    private Button suaHH_Button;

    @FXML
    private Button themHH_Button;

    @FXML
    private Button xoaHH_Button;

    @FXML
    private Button timKiemHH_Button;

    @FXML
    private TextField timKiem_TextField;

    @FXML
    private AnchorPane display_Form;


    @FXML
    private AnchorPane themHH_Form;

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


    public void loadDataFromDatabase() {
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM danhMucHH");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products_Data.add(new HangHoa_Module(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        quanLyHH_Table.setItems(products_Data);
    }
    public void setCellQuanLyHH_Table(){
        maHang_Col.setCellValueFactory(new PropertyValueFactory<>("maHang"));
        tenHang_Col.setCellValueFactory(new PropertyValueFactory<>("tenHang"));
        donViTinh_Col.setCellValueFactory(new PropertyValueFactory<>("donViTinh"));
        giaNhap_Col.setCellValueFactory(new PropertyValueFactory<>("giaNhap"));
        giaXuat_Col.setCellValueFactory(new PropertyValueFactory<>("giaXuat"));
        giaBanLe_Col.setCellValueFactory(new PropertyValueFactory<>("giaBanLe"));
    }

    public void switchForm(ActionEvent event) throws IOException {
        if (event.getSource() == themHH_Button) {
            themHH_Form.setVisible(true);
            display_Form.setVisible(false);
        }

    }

    int index = -1;
    public String curentID;
    @FXML
    void getSelected(MouseEvent event1){
        index = quanLyHH_Table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return ;
        }
        maHH_Label.setText(maHang_Col.getCellData(index).toString());
        tenHH_Label.setText(tenHang_Col.getCellData(index).toString());
        donViTinh_Label.setText(donViTinh_Col.getCellData(index).toString());
        giaNhap_Label.setText(giaNhap_Col.getCellData(index).toString());
        giaXuat_Label.setText(giaXuat_Col.getCellData(index).toString());
        giaBanLe_Label.setText(giaBanLe_Col.getCellData(index).toString());
        curentID = maHang_Col.getCellData(index).toString();
    }
    public void Delete(){
        conn = DBConnection.ConnectionDB();
        String sql = "DELETE FROM danhMucHH WHERE maHang = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, curentID);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            setCellQuanLyHH_Table();
            loadDataFromDatabase();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Add(ActionEvent event){
        maHH_Label.clear();
        tenHH_Label.clear();
        donViTinh_Label.clear();
        giaNhap_Label.clear();
        giaXuat_Label.clear();
        giaBanLe_Label.clear();
        display_Form.setVisible(false);
        themHH_Form.setVisible(true);
    }

    public void saveButton() {
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
        setCellQuanLyHH_Table();
        loadDataFromDatabase();
        themHH_Form.setVisible(false);
        display_Form.setVisible(true);
    }

    public void Update(){
        display_Form.setVisible(false);
        themHH_Form.setVisible(true);
    }

    public void Edit(){
        try {
            conn = DBConnection.ConnectionDB();
            String value1 = maHH_Label.getText();
            String value2 = tenHH_Label.getText();
            String value3 = donViTinh_Label.getText();
            String value4 = giaNhap_Label.getText();
            String value5 = giaXuat_Label.getText();
            String value6 = giaBanLe_Label.getText();
            String sql = "update danhMucHH set maHang= '"+value1+"',tenHang= '"+value2+"',donViTinh= '"+
                    value3+"',giaNhap= '"+value4+"',giaXuat= '"+value5+"',giaBanLe= '"+value6+"' where maHang='"+value1+"' ";
            preparedStatement= conn.prepareStatement(sql);
            preparedStatement.execute();
            setCellQuanLyHH_Table();
            loadDataFromDatabase();
            display_Form.setVisible(true);
            themHH_Form.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conn = DBConnection.ConnectionDB();
        products_Data = FXCollections.observableArrayList();
        setCellQuanLyHH_Table();
        loadDataFromDatabase();
    }

}
