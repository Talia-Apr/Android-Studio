package com.smkrevit.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvhasil;

    EditText etBil1, etBil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        tvhasil = findViewById(R.id.tvHasil);
        etBil1 = findViewById(R.id.etBil1);
        etBil2 = findViewById(R.id.etBil2);
    }

    public void btnJumlah(View view) {

        if (etBil1.getText().toString().equals("") || etBil2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong!", Toast.LENGTH_SHORT).show();
        }else{
            double bil1 = Double.parseDouble(etBil1.getText().toString());
            double bil2 = Double.parseDouble(etBil2.getText().toString());

            double hasil = bil1 + bil2;

            tvhasil.setText(hasil+"");
        }

    }

    public void btnKurang(View view) {

        if (etBil1.getText().toString().equals("") || etBil2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong!", Toast.LENGTH_SHORT).show();
        }else{
            double bil1 = Double.parseDouble(etBil1.getText().toString());
            double bil2 = Double.parseDouble(etBil2.getText().toString());

            double hasil = bil1 - bil2;

            tvhasil.setText(hasil+"");
        }

    }

    public void btnKali(View view) {

        if (etBil1.getText().toString().equals("") || etBil2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong!", Toast.LENGTH_SHORT).show();
        }else{
            double bil1 = Double.parseDouble(etBil1.getText().toString());
            double bil2 = Double.parseDouble(etBil2.getText().toString());

            double hasil = bil1 * bil2;

            tvhasil.setText(hasil+"");
        }

    }

    public void btnBagi(View view) {

        if (etBil1.getText().toString().equals("") || etBil2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong!", Toast.LENGTH_SHORT).show();
        }else{
            double bil1 = Double.parseDouble(etBil1.getText().toString());
            double bil2 = Double.parseDouble(etBil2.getText().toString());

            double hasil = bil1 / bil2;

            tvhasil.setText(hasil+"");
        }

    }
}