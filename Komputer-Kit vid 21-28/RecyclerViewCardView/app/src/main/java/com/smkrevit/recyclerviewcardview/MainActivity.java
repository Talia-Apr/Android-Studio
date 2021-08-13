package com.smkrevit.recyclerviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        isiData();
    }

    public void load(){
        recyclerview = findViewById(R.id.rcvSiswa);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("Kimberly", "Jakarta"));
        siswaList.add(new Siswa("Lily", "Jakarta"));
        siswaList.add(new Siswa("Meni", "Jakarta"));
        siswaList.add(new Siswa("Patricia", "Jakarta"));
        siswaList.add(new Siswa("Feni", "Jakarta"));
        siswaList.add(new Siswa("Reyna", "Jakarta"));
        siswaList.add(new Siswa("Nita", "Jakarta"));
        siswaList.add(new Siswa("Ayla", "Jakarta"));

        adapter = new SiswaAdapter(this, siswaList);
        recyclerview.setAdapter(adapter);
    }

    public void btnTambah(View view) {
        siswaList.add(new Siswa("KIMBERLY", "JAKARTA"));
        adapter.notifyDataSetChanged();
    }
}