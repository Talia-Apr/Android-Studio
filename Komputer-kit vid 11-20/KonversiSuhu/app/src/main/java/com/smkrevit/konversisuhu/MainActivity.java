package com.smkrevit.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etNilai;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load() {
        spinner = findViewById(R.id.spinner);
        etNilai = findViewById(R.id.etNilai);
        tvHasil = findViewById(R.id.tvHasil);
    }

    /*
    public void isiSpinner(){
        String[] isi = {"Celcius to Reamur", "Celcius to Farenheit", "Celcius to Kelvin"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, isi);
        spinner.setAdapter(adapter);
    }
     */

    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if (etNilai.getText().toString().equals("")){
            Toast.makeText(this, "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else{
            if (pilihan.equals("Celcius to Reamur")){
                cToR();
            }

            if (pilihan.equals("Celcius to Fahrenheit")){
                cToF();
            }

            if (pilihan.equals("Celcius to Kelvin")){
                cToK();
            }

            if (pilihan.equals("Reamur to Celcius")){
                rToC();
            }

            if (pilihan.equals("Reamur to Fahrenheit")){
                rToF();
            }

            if (pilihan.equals("Reamur to Kelvin")){
                rToK();
            }

            if (pilihan.equals("Fahrenheit to Celcius")){
                fToC();
            }

            if (pilihan.equals("Fahrenheit to Reamur")){
                fToR();
            }

            if (pilihan.equals("Fahrenheit to Kelvin")){
                fToK();
            }

            if (pilihan.equals("Kelvin to Celcius")){
                kToC();
            }

            if (pilihan.equals("Kelvin to Reamur")){
                kToR();
            }

            if (pilihan.equals("Kelvin to Fahrenheit")){
                kToF();
            }
        }
    }

    public void cToR(){
        double celcius = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0/5.0) * celcius;

        tvHasil.setText(hasil+"");
    }

    public void cToF(){
        double celcius = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9.0/5.0) * celcius + 32.0;

        tvHasil.setText(hasil+"");
    }

    public void cToK(){
        double celcius = Double.parseDouble(etNilai.getText().toString());
        double hasil = celcius + 273.0;

        tvHasil.setText(hasil+"");
    }

    public void rToC(){
        double reamur = Double.parseDouble(etNilai.getText().toString());
        double hasil = (5.0/4.0) * reamur;

        tvHasil.setText(hasil+"");
    }

    public void rToF(){
        double reamur = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9.0/4.0) * reamur + 32.0;

        tvHasil.setText(hasil+"");
    }

    public void rToK(){
        double reamur = Double.parseDouble(etNilai.getText().toString());
        double hasil = (5.0/4.0) * reamur + 273.0;

        tvHasil.setText(hasil+"");
    }

    public void fToC(){
        double fahrenheit = Double.parseDouble(etNilai.getText().toString());
        double hasil = (5.0/9.0) * fahrenheit - 32.0;

        tvHasil.setText(hasil+"");
    }

    public void fToR(){
        double fahrenheit = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0/9.0) * fahrenheit - 32.0;

        tvHasil.setText(hasil+"");
    }

    public void fToK(){
        double fahrenheit = Double.parseDouble(etNilai.getText().toString());
        double hasil = (5.0/9.0) * fahrenheit - 32.0 + 273.0;

        tvHasil.setText(hasil+"");
    }

    public void kToC(){
        double kelvin = Double.parseDouble(etNilai.getText().toString());
        double hasil = kelvin - 273.0;

        tvHasil.setText(hasil+"");
    }

    public void kToR(){
        double kelvin = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0/5.0) * kelvin - 273.0;

        tvHasil.setText(hasil+"");
    }

    public void kToF(){
        double kelvin = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9.0/5.0) * kelvin - 273.0 + 32.0;

        tvHasil.setText(hasil+"");
    }

}