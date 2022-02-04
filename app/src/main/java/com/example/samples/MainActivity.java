package com.example.samples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.samples.dialogs.SampleSpecificDialog;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Button showSampleDialog; // кнопка для создания диалога
    Button goToNavActivity; //  кнопка для перехода на активность с навигацией

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSampleDialog = findViewById(R.id.bt_show_sample_dialog);
        goToNavActivity = findViewById(R.id.bt_go_to_nav);


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


    }
}