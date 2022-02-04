package com.example.samples.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.samples.R;

import java.util.ArrayList;

public class SampleSpecificDialog extends SampleAbstractDialog {

    private Button sampleButton; // кнопка в диалоге
    private EditText sampleEditText; // TextView в диалоге
    Object object1, object2, object3; // какие-либо обьекты, необходимые для работы диалога, получаемые при создании объекта диалога

    // конструктор для активности с доп. параметрами
    public SampleSpecificDialog(@NonNull AppCompatActivity activity, Object object1, Object object2, Object object3) {
        super(activity);
        this.object1 = object1;
        this.object2 = object2;
        this.object3 = object3;
    }

    // конструктор для фрагмента с доп. параметрами
    public SampleSpecificDialog(@NonNull Fragment fragment, Object object1, Object object2, Object object3) {
        super(fragment);
        this.object1 = object1;
        this.object2 = object2;
        this.object3 = object3;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.sample_dialog_layout, container, false); // получение коренного View диалога (разметка)
        sampleButton = rootView.findViewById(R.id.sample_button); // получение кнопки
        sampleEditText = rootView.findViewById(R.id.sample_edit_text); // получение EditText

        // слушатель нажатия для кнопки
        sampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, sampleEditText.getText().toString(), Toast.LENGTH_LONG).show(); // сообщение с текстом из sampleEditText
                destroy(); // уничтожение диалога с помощью метода суперкласса
            }
        });


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
