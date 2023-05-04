package com.example.project_i.HangHoa;

public class HangHoa_Module {
    public Integer maHang;
    public String tenHang;
    public String donViTinh;
    public Double giaNhap;
    public Double giaXuat;
    public Double giaBanLe;

    public HangHoa_Module() {
    }

    public HangHoa_Module(Integer maHang, String tenHang, String donViTinh, Double giaNhap, Double giaXuat, Double giaBanLe) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
        this.giaBanLe = giaBanLe;
    }

    public Integer getMaHang() {
        return maHang;
    }

    public void setMaHang(Integer maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(Double giaXuat) {
        this.giaXuat = giaXuat;
    }

    public Double getGiaBanLe() {
        return giaBanLe;
    }

    public void setGiaBanLe(Double giaBanLe) {
        this.giaBanLe = giaBanLe;
    }
}
