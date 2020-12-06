package com.example.sqlite_konter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private com.example.sqlite_konter.MyDatabase db;
    private EditText Enohp, Eharga, Ejenis;
    private String Snohp, Sharga, Sjenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);

        db = new com.example.sqlite_konter.MyDatabase(this);
        Enohp = (EditText) findViewById(R.id.create_nohp);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Ejenis = (EditText) findViewById(R.id.create_jenis);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snohp = String.valueOf(Enohp.getText());
                Sharga = String.valueOf(Eharga.getText());
                Sjenis = String.valueOf(Ejenis.getText());

                if (Snohp.equals("")){
                    Enohp.requestFocus();
                    Toast.makeText(com.example.sqlite_konter.MainCreate.this, "Silahkan isi Nohp",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(com.example.sqlite_konter.MainCreate.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(com.example.sqlite_konter.MainCreate.this, "Silahkan isi Jenis Paket", Toast.LENGTH_SHORT).show();
                } else {
                    Enohp.setText("");
                    Eharga.setText("");
                    Ejenis.setText("");
                    Toast.makeText(com.example.sqlite_konter.MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePulsa(new Konter(null, Snohp,Sharga, Sjenis));
                    Intent a = new Intent(com.example.sqlite_konter.MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
