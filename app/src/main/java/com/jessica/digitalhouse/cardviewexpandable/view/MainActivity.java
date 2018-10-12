package com.jessica.digitalhouse.cardviewexpandable.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jessica.digitalhouse.cardviewexpandable.R;
import com.jessica.digitalhouse.cardviewexpandable.adapter.AdapterRecyclerView;
import com.jessica.digitalhouse.cardviewexpandable.model.Grade;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaGrade = findViewById(R.id.recyclerViewGrade);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        AdapterRecyclerView adapter = new AdapterRecyclerView(getList(), this);

        listaGrade.setLayoutManager(layoutManager);
        listaGrade.setAdapter(adapter);

    }

    private List<Grade> getList(){
        List<Grade> list = new ArrayList<>();

        list.add(new Grade("Segunda-feira","Mobile", "Guilherme", "14-16h", R.drawable.segunda));
        list.add(new Grade("Terça-feira","Mobile", "Guilherme", "14-16h",R.drawable.terca));
        list.add(new Grade("Quarta-feira","Mobile", "Guilherme", "14-16h",R.drawable.quarta));
        list.add(new Grade("Quinta-feira","Mobile", "Guilherme", "14-16h", R.drawable.quinta));
        list.add(new Grade("Sexta-feira","Mobile", "Guilherme", "14-16h",R.drawable.sexta));

        return list;
    }
}
