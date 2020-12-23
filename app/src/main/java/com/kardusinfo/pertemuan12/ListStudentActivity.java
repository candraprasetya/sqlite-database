package com.kardusinfo.pertemuan12;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListStudentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private ArrayList<Student> students;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        recyclerView = findViewById(R.id.rv_student);
        adapter = new StudentAdapter(this);
        dbHelper = new DbHelper(this);
        students = dbHelper.getAllStudents();
        adapter.setStudents(students);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListStudentActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}