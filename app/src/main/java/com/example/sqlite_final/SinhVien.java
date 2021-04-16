package com.example.sqlite_final;

public class SinhVien {
    public static final String TABLE_NAME = "sinh_vien";
    public static final String COL_ID = "id";
    public static final String COL_MSSV ="mssv";
    public static final String COL_HOTEN = "hoten";
    public static final String COL_DIEMTK = "diemtk";

    public static final String TAO_BANG = "CREATE TABLE " + TABLE_NAME + " ("
            +COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_MSSV+ " TEXT, "
            +COL_HOTEN+" TEXT, "
            +COL_DIEMTK+" REAL)";

    public static final String XOA_BANG ="DROP TABLE IF EXIST "+ TABLE_NAME;
    private String MSSV;
    private String HoTen;
    private float DiemTK;

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public float getDiemTK() {
        return DiemTK;
    }

    public void setDiemTK(float diemTK) {
        DiemTK = diemTK;
    }

    public SinhVien(String mssv, String hoten, float diemtk){
        this.MSSV = mssv;
        this.HoTen = hoten;
        this.DiemTK = diemtk;
    }
}
