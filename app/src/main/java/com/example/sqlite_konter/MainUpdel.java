package com.example.sqlite_konter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private com.example.sqlite_konter.MyDatabase db;
    private String Sid, Snohp, Sharga , Sjenis;
    private EditText Enohp, Eharga , Ejenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new com.example.sqlite_konter.MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snohp = i.getStringExtra("Inohp");
        Sharga = i.getStringExtra("Iharga");
        Sjenis = i.getStringExtra("Ijenis");

        Enohp = (EditText) findViewById(R.id.updel_nohp);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);

        Enohp.setText(Snohp);
        Eharga.setText(Sharga);
        Ejenis.setText(Sjenis);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snohp = String.valueOf(Enohp.getText());
                Sharga = String.valueOf(Eharga.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                if (Snohp.equals("")){
                    Enohp.requestFocus();
                    Toast.makeText(com.example.sqlite_konter.MainUpdel.this, "Silahkan isi nama produk",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(com.example.sqlite_konter.MainUpdel.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(com.example.sqlite_konter.MainUpdel.this, "Silahkan isi stok ",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    db.UpdatePulsa(new Konter(Sid, Snohp, Sharga, Sjenis));
                    Toast.makeText(com.example.sqlite_konter.MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePulsa(new Konter(Sid, Snohp, Sharga, Sjenis));
                Toast.makeText(com.example.sqlite_konter.MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
