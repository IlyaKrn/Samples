package com.example.samples.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * абстрактный класс диалога нужен для того,
 * чтобы сделать для каждого диалога одинаковые
 * методы для создания, уничтожения диалога,
 * одинаковые поля для упрощения разработки
 * */

public abstract class SampleAbstractDialog extends Fragment {

    /**
     * документация на класс <a href="https://developer.android.com/reference/android/util/Log">Log</a><br/>
     * как использовать (более наглядно) <a href="http://developer.alexanderklimov.ru/android/debug/logcat.php">Log</a>
     * */
    public static final String LOG_TAG = "SampleDialogLog";    // тег для логгирования

    /**
     * документация на класс <a href="https://developer.android.com/reference/android/view/View">View</a><br/>
     * */
    protected View rootView; // коренное View диалога
    /**
     * FragmentManager - класс для управления фрагментами<br/>
     * с его помощью можно:<br/>
     * прикреплять/откреплять фракмент от активности или другого фрагмента<br/>
     * создавать/уничтожать фрагменты<br/>
     * и т.д.<br/>
     * подробнее в <a href="https://developer.android.com/guide/fragments/fragmentmanager">документации</a>
     * */
    protected FragmentManager fragmentManager; // FragmentManager для создания и удаление диалога
    /**
     * документация на класс <a href="https://developer.android.com/reference/android/content/Context">Context</a><br/>
     * более понятно <a href="http://developer.alexanderklimov.ru/android/theory/context.php">Context</a>
     * */
    protected Context context; // контекст фрагмента или активности, в в которой был вызван диалог


    /**
     * документация на класс <a href="https://developer.android.com/reference/android/app/Activityg">Activity</a><br/>
     * более понятно <a href="http://developer.alexanderklimov.ru/android/theory/activity-theory.php">Activity</a>
     * */
    // конструктор для создания диалога внутри активности
    // в качестве активности передаётся активность, в которой надо создать диалог
    public SampleAbstractDialog(@NonNull AppCompatActivity activity) {
        context = activity.getApplicationContext();
        fragmentManager = activity.getSupportFragmentManager();
    }
    /**
     * документация на класс <a href="https://developer.android.com/guide/fragments">Fragment</a><br/>
     * более понятно <a href="http://developer.alexanderklimov.ru/android/fragment.php">Fragment</a>
     * */
    // конструктор для создания диалога внутри фрагмента
    // в качестве фрагмента передаётся фрагмент, в котором надо создать диалог
    public SampleAbstractDialog(@NonNull Fragment fragment) {
        context = fragment.getContext(); // контекст, полученный от фрагмента, в котором был вызван диалог (не проверено. может неработать)
        context = fragment.getActivity().getApplicationContext(); // контекст, полученный от активности фрагмента, в котором был вызван диалог (проверено. работает)
        fragmentManager = fragment.getChildFragmentManager();
    }


    // onCreateView возвращает коренное View диалога
    // при реализации конкретного класса диалога,
    // наследуемого от данного абстрактного класса,
    // при переопределении метода onCreateView необходимо вызывать
    // метод суперкласса onCreateView в самом конце метода конкретного класса
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return rootView;
    }
    // метод для создания диалога
    // вызывается при необходимости создания
    // диалога в активности или фрагменте.
    // в параметр containerId указывается id
    // контейнера, в котором будет создан диалог
    public void create(int containerId){
        fragmentManager.beginTransaction().add(containerId, this).commit();
    }
    // метод для уничтожения диалога
    // вызывается при необходимости уничтожения
    // диалога в активности или фрагменте
    protected void destroy(){
        fragmentManager.beginTransaction().remove(this).commit();
    }
}
