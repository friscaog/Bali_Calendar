package com.example.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by A455L CORE i5 on 12/26/2017.
 */

public class PawukonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> nama;
    private List<String> hasil;

    public PawukonAdapter(List<String> nama, List<String> hasil) {
        this.nama = nama;
        this.hasil = hasil;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PawukonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pawukon,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PawukonViewHolder)holder).bind(nama.get(position),hasil.get(position),position);
    }

    @Override
    public int getItemCount() {
        return nama.size();
    }

    private class PawukonViewHolder extends RecyclerView.ViewHolder {
        TextView nama = (TextView)itemView.findViewById(R.id.nama);
        TextView hasil = (TextView)itemView.findViewById(R.id.hasil);
        public PawukonViewHolder(View itemView) {
            super(itemView);
        }


        public void bind(String s, String s1, int position) {
            nama.setText(s);
            hasil.setText(s1);
        }
    }

}
