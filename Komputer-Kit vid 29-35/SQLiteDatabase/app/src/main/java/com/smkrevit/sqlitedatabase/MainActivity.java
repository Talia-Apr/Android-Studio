package com.smkrevit.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText etBarang, etStok, etHarga;
    TextView tvPilihan;

    List<Barang> dataBarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    RecyclerView rcvBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        selectData();
    }

    public void load(){
        db = new Database(this);
        db.buatTabel();

        etBarang = findViewById(R.id.etBarang);
        etStok = findViewById(R.id.etStok);
        etHarga = findViewById(R.id.etHarga);
        tvPilihan = findViewById(R.id.tvPilihan);
        rcvBarang = findViewById(R.id.rcvBarang);

        rcvBarang.setLayoutManager(new LinearLayoutManager(this));
        rcvBarang.setHasFixedSize(true);
    }

    public void simpan(View v) {
        String barang = etBarang.getText().toString();
        String stok = etStok.getText().toString();
        String harga = etHarga.getText().toString();
        String pilihan = tvPilihan.getText().toString();

        if (barang.isEmpty() || stok.isEmpty() || harga.isEmpty() ){
            pesan("Data Belum Lengkap");
        } else {
            if (pilihan.equals("insert")){
                String sql = "INSERT INTO tblbarang (barang, stok, harga) VALUES ('"+barang+"', "+stok+", "+harga+")";
                if (db.runSQL(sql)){
                    pesan("Insert Berhasil");
                    selectData();
                } else {
                    pesan("Insert Gagal");
                }
            }else{
                pesan("Update");
            }
        }

        etBarang.setText("");
        etStok.setText("");
        etHarga.setText("");
        tvPilihan.setText("insert");
    }

    public void pesan (String isi){
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }

    public void selectData(){
        String sql = "SELECT * FROM tblbarang ORDER BY barang ASC";
        Cursor cursor = db.select(sql);
        dataBarang.clear();
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()) {
                String idbarang = cursor.getString(cursor.getColumnIndex("idbarang"));
                String barang = cursor.getString(cursor.getColumnIndex("barang"));
                String stok = cursor.getString(cursor.getColumnIndex("stok"));
                String harga = cursor.getString(cursor.getColumnIndex("harga"));

                dataBarang.add(new Barang(idbarang, barang, stok, harga));
            }

            adapter = new BarangAdapter(this, dataBarang);
            rcvBarang.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }else{
            pesan("Data Kosong");
        }
    }

    public void deletedata(String id){
        String idbarang = id;
        String sql = "DELETE FROM tblbarang WHERE idbarang= "+idbarang+";";
        if (db.runSQL(sql)){
            pesan("Data Sudah Dihapus");
            selectData();
        } else {
            pesan("Data Gagal Dihapus");
        }
    }
}