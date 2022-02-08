package com.example.samples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.samples.dialogs.SampleSpecificDialog;
import com.example.samples.firebaseobjects.SampleRecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button showSampleDialog; // кнопка для создания диалога
    Button goToNavActivity; //  кнопка для перехода на активность с навигацией
    RecyclerView recyclerView; // список

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSampleDialog = findViewById(R.id.bt_show_sample_dialog);
        goToNavActivity = findViewById(R.id.bt_go_to_nav);
        recyclerView = findViewById(R.id.sample_recycler_view);


        // создание диалога при нажатии на кнопку
        showSampleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // создание объекта диалога
                SampleSpecificDialog dialog = new SampleSpecificDialog(MainActivity.this, new Object(), new Object(), new Object());
                // создание диалога в указанном контейнере
                dialog.create(R.id.sample_dialog_container);
            }
        });
        goToNavActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SampleBottomNavigationActivity.class);
                startActivity(intent);
            }
        });

        // recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Object> sampleList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            sampleList.add(new Object());
        }
        recyclerView.setAdapter(new SampleRecyclerViewAdapter(this, sampleList, new SampleRecyclerViewAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(int itemPosition) {
                Toast.makeText(getApplicationContext(), "item with index " + itemPosition +" was clicked", Toast.LENGTH_SHORT).show();
            }
        }));

    }
}