package com.example.sqlite_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class DSSVActivity extends AppCompatActivity {

    DBSinhVienHelper dbSinhVienHelper;
    SVAdapter svAdapter;
    RecyclerView recyclerView;
    LinkedList<SinhVien> mDataSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_s_s_v);
        dbSinhVienHelper = new DBSinhVienHelper(this);
        mDataSet = dbSinhVienHelper.DSSV();
        svAdapter = new SVAdapter(this, mDataSet);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(svAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}