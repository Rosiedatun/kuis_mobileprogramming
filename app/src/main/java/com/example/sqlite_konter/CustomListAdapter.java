package com.example.sqlite_konter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Konter> movieItems;
    public CustomListAdapter(Activity activity, List<Konter> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.costum_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nohp);
        TextView namaakun = (TextView) convertView.findViewById(R.id.text_akun);
        TextView stok = (TextView) convertView.findViewById(R.id.text_jenis);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        Konter m = movieItems.get(position);
        nama.setText("Nohp : "+ m.get_nohp());
        namaakun.setText("Harga : "+ m.get_harga());
        stok.setText("JenisPaket : "+ m.get_jenis());
        return convertView;
    }
}
