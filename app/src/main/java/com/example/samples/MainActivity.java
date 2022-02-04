package com.example.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.samples.dialogs.SampleSpecificDialog;

public class MainActivity extends AppCompatActivity {

    Button showSampleDialog; // кнопка для создания диалога

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSampleDialog = findViewById(R.id.bt_show_sample_dialog);

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
    }
}