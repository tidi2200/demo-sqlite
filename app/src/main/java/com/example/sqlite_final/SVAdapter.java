package com.example.sqlite_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class SVAdapter extends RecyclerView.Adapter<SVAdapter.SVViewHolder> {
    final LinkedList<SinhVien> mDataSet;
    LayoutInflater mInflater;

    public SVAdapter(Context context, LinkedList<SinhVien> mDataSet) {
        this.mDataSet = mDataSet;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.sv_item, parent, false);
        return new SVViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SVViewHolder holder, int position) {
        SinhVien sv = this.mDataSet.get(position);
        holder.txtMSSV.setText(sv.getMSSV());
        holder.txtHoTen.setText(sv.getHoTen());
        holder.txtDiemTK.setText(String.valueOf(sv.getDiemTK()));
    }

    @Override
    public int getItemCount() {
        return this.mDataSet.size();
    }

    public class SVViewHolder extends RecyclerView.ViewHolder {
        final TextView txtMSSV, txtHoTen, txtDiemTK;
        final SVAdapter mAdapter;
        public SVViewHolder(@NonNull View itemView,final SVAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;
            this.txtMSSV = itemView.findViewById(R.id.txt_mssvitem);
            this.txtHoTen = itemView.findViewById(R.id.txt_hotenitem);
            this.txtDiemTK = itemView.findViewById(R.id.txt_diemtkitem);
        }
    }
}
