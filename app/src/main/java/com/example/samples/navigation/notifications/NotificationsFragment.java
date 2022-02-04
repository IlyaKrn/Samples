package com.example.samples.navigation.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.samples.databinding.FragmentNotificationsBinding;

/**
 * получение View (в данном случае - кнопки)<br/>
 * с помощью findViewById<br/>
 * Button button = findViewById(R.id.some_button);<br/>
 *<br/>
 * с помощью биндинга<br/>
 * Button button = binding.someButton;<br/>
 * */

public class NotificationsFragment extends Fragment {

    private static NotificationsCallback callback;
    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // установка методов обратного вызова, определенных в активности
    // вызываются в этом фрагменте
    public static void setCallback(NotificationsCallback callback) {
        NotificationsFragment.callback = callback;
    }
}