package com.example.sqlite_konter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead  extends AppCompatActivity implements
        AdapterView.OnItemClickListener{

    private ListView mListView;
    private com.example.sqlite_konter.CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Konter> ListKonter = new ArrayList<Konter>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new com.example.sqlite_konter.CustomListAdapter(this, ListKonter);
        mListView = (ListView) findViewById(R.id.list_pulsa);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListKonter.clear();

        List<Konter> contacts = db.ReadPulsa();
        for (Konter cn : contacts) {
            Konter judulModel = new Konter();
            judulModel.set_id(cn.get_id());
            judulModel.set_nohp(cn.get_nohp());
            judulModel.set_harga(cn.get_harga());
            judulModel.set_jenis(cn.get_jenis());
            ListKonter.add(judulModel);
            if ((ListKonter.isEmpty()))
                Toast.makeText(com.example.sqlite_konter.MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Konter obj_itemDetails = (Konter) o;
        String Sid = obj_itemDetails.get_id();
        String Snohp = obj_itemDetails.get_nohp();
        String Sharga = obj_itemDetails.get_harga();
        String Sjenis = obj_itemDetails.get_jenis();
        Intent goUpdel = new Intent(com.example.sqlite_konter.MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inohp", Snohp);
        goUpdel.putExtra("Iharga", Sharga);
        goUpdel.putExtra("Ijenis", Sjenis);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListKonter.clear();
        mListView.setAdapter(adapter_off);
        List<Konter> contacts = db.ReadPulsa();
        for (Konter cn : contacts) {
            Konter judulModel = new Konter();
            judulModel.set_id(cn.get_id());
            judulModel.set_nohp(cn.get_nohp());
            judulModel.set_harga(cn.get_harga());
            judulModel.set_jenis(cn.get_jenis());
            ListKonter.add(judulModel);
            if ((ListKonter.isEmpty()))
                Toast.makeText(com.example.sqlite_konter.MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
