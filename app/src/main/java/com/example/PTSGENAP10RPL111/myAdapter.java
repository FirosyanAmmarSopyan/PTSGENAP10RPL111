package com.example.PTSGENAP10RPL111;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MahasiswaViewHolder> {


    private ArrayList<dataMahasiswa> dataList;

    public myAdapter(ArrayList<dataMahasiswa> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.show_mahasiswa, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtNpm.setText(dataList.get(position).getNim());
        holder.txtNoHp.setText(dataList.get(position).getNohp());
        holder.txtemail.setText(dataList.get(position).getEmail());
        holder.txtttl.setText(dataList.get(position).getTtl());
    }
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNpm, txtNoHp , txtemail, txtttl;

        public MahasiswaViewHolder(View show_mahasiswa) {
            super(show_mahasiswa);
            txtNama = (TextView) show_mahasiswa.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm = (TextView) show_mahasiswa.findViewById(R.id.txt_npm_mahasiswa);
            txtNoHp = (TextView) show_mahasiswa.findViewById(R.id.txt_nohp_mahasiswa);
            txtemail = (TextView) show_mahasiswa.findViewById(R.id.txtemail);
            txtttl =(TextView)show_mahasiswa.findViewById(R.id.txtttl);
        }
    }
}