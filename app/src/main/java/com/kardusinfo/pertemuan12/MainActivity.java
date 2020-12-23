package com.kardusinfo.pertemuan12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DbHelper dbHelper;
    private EditText edtNama, edtNim;
    private Button btnSave, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        edtNama = findViewById(R.id.edt_nama);
        edtNim = findViewById(R.id.edt_nim);
        btnSave = findViewById(R.id.btn_submit);
        btnList = findViewById(R.id.btn_list);
        
        btnSave.setOnClickListener(v -> {
            if(edtNama.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Nim harus diisi terlebih dahulu", Toast.LENGTH_SHORT).show();
            }else if(edtNim.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Nama harus diisi terlebih dahulu", Toast.LENGTH_SHORT).show();
            }else{
                dbHelper.addUserDetail(edtNim.getText().toString(), edtNama.getText().toString());
                edtNama.setText("");
                edtNim.setText("");
                Toast.makeText(MainActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
            }
        });
        
        btnList.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ListStudentActivity.class)));
    }
}