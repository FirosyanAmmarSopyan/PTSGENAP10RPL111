package com.example.PTSGENAP10RPL111;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class menu extends AppCompatActivity {
    private RecyclerView recyclerView;
    private myAdapter adapter;
    private ArrayList<dataMahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = (RecyclerView) findViewById(R.id.rvdata);
        addData();
        adapter = new myAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(menu.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new dataMahasiswa("JONI", "1890467892873", "085741960341","jonigeming10@gmail.com","kudus 26 Januari 2005"));
        mahasiswaArrayList.add(new dataMahasiswa("TERY", "1890467892877", "085944827290", "terylucknut@gmail.com", "Semarang 10 februari 2006"));
        mahasiswaArrayList.add(new dataMahasiswa("KUNYUK", "1274873597259", "087809294398", "kunyukfamss@gmail.com", "surabaya 05 Juni 2007"));
        mahasiswaArrayList.add (new dataMahasiswa("JAMED", "179849743252005" , "0859005003395", "jamedallbase@gmail.com", "Palembang 09 mei 2008"));
    }
}