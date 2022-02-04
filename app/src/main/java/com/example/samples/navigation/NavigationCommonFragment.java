package com.example.samples.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public abstract class NavigationCommonFragment extends Fragment {

    public static final String LOG_TAG = "HubNavigationLog";

    // константы для определения текущего фрагмента навигации
    public static final String DASHBOARD = "dashboard";
    public static final String HOME = "home";
    public static final String NOTIFICATIONS = "notifications";

    // текущий фрагмент навигации
    public static String currentNavigationFragment;

    // корневой элемент
    protected View root;

    protected StorageReference firebaseStorage; // хранилище картинок
    protected DatabaseReference firebaseDatabase;  // бд (Firebase)
    protected FirebaseAuth auth; // аутентификация


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        init(inflater, container, savedInstanceState);
        // инициализация объектов для работы с firebase
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseStorage = FirebaseStorage.getInstance().getReference();
        auth = FirebaseAuth.getInstance();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addSampleNavigationActivityCallback();
    }

    // установка методов обратного вызова, которые будут вызываться в активности
    protected abstract void addSampleNavigationActivityCallback();

    // метод для инициализации полей
    // нужен исключительно для удобства
    // если код из этого метода перенести в onCreateView,
    // то ничего не изменится
    protected abstract void init(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


}
