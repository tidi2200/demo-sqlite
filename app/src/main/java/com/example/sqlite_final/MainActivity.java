package com.example.sqlite_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBSinhVienHelper dbSinhVienHelper;
    EditText txtMSSV, txtHoten, txtDiemtk;
    Button btnCapNhat, btnXoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbSinhVienHelper = new DBSinhVienHelper(this);
        txtMSSV = findViewById(R.id.txtmssv);
        txtHoten = findViewById(R.id.txthoten);
        txtDiemtk = findViewById(R.id.txtdiemtk);
        btnCapNhat = findViewById(R.id.btn_capnhat);
        btnXoa = findViewById(R.id.btn_xoa);
    }

    public void addSV(View view) {
        String mssv = txtMSSV.getText().toString();
        String hoten = txtHoten.getText().toString();
        String diemtk = txtDiemtk.getText().toString();
        SinhVien sv = new SinhVien(mssv, hoten, Float.valueOf(diemtk));
        long id = dbSinhVienHelper.addSV(sv);
        if(id > 0)
            Toast.makeText(this,"Them thanh cong", Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this, "Them khong thanh cong", Toast.LENGTH_SHORT).show();
        }
    }

    public void showDSSV(View view) {
        Intent intent = new Intent(MainActivity.this,DSSVActivity.class);
        startActivity(intent);
    }

    public void timKiem(View view) {
        String mssv = txtMSSV.getText().toString();
        SinhVien sv = dbSinhVienHelper.timKiem(mssv);
        boolean Exist = (sv!=null);
        if(Exist){
            Toast.makeText(this,"Tim thay thong tin", Toast.LENGTH_SHORT).show();
            txtHoten.setText(sv.getHoTen());
            txtDiemtk.setText(String.valueOf(sv.getDiemTK()));
            btnCapNhat.setEnabled(Exist);
            btnXoa.setEnabled(Exist);
        }
        else{
            Toast.makeText(this,"Khong tim thay",Toast.LENGTH_SHORT).show();
            btnCapNhat.setEnabled(Exist);
            btnXoa.setEnabled(Exist);
        }
    }

    public void xoaSV(View view) {
        String mssv = txtMSSV.getText().toString();
        Integer flag = dbSinhVienHelper.xoaSV(mssv);
        if(flag >0){
            Toast.makeText(this,"Xoa thanh cong", Toast.LENGTH_SHORT).show();
            txtMSSV.setText(null);
            txtHoten.setText(null);
            txtDiemtk.setText(null);
        }
        else
            Toast.makeText(this,"Khong tim thay thong tin xoa", Toast.LENGTH_SHORT).show();
    }

    public void capNhatSV(View view) {
        String mssv = txtMSSV.getText().toString();
        String hoten = txtHoten.getText().toString();
        String diemtk = txtDiemtk.getText().toString();
        SinhVien sv = new SinhVien(mssv,hoten,Float.valueOf(diemtk));
        Integer success = dbSinhVienHelper.capNhatSV(sv);
        if(success > 0)
            Toast.makeText(this,"Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Cap nhat khong thanh cong", Toast.LENGTH_SHORT).show();
    }
}