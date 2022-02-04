package com.example.samples;

import android.os.Bundle;

import com.example.samples.navigation.SampleNavigationActivityCallback;
import com.example.samples.navigation.dashboard.DashboardCallback;
import com.example.samples.navigation.dashboard.DashboardFragment;
import com.example.samples.navigation.home.HomeCallback;
import com.example.samples.navigation.home.HomeFragment;
import com.example.samples.navigation.notifications.NotificationsCallback;
import com.example.samples.navigation.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.samples.databinding.ActivitySampleBottomNavigationBinding;

import java.util.ArrayList;

public class SampleBottomNavigationActivity extends AppCompatActivity {

    // итерфейсы обратных вызовав
    // создаются в классах фрагментов навигации в методе addSampleNavigationActivityCallback
    // вызываются в этой активности
    private static SampleNavigationActivityCallback dashboardCallback;
    private static SampleNavigationActivityCallback homeCallback;
    private static SampleNavigationActivityCallback notificationsCallback;


    private ActivitySampleBottomNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySampleBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_sample_bottom_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        setCallbacks();
    }

    // установка интерфейсов обратного вызова в фрагменты навигации
    // они вызываются в фрагментах навигации
    private void setCallbacks(){
        DashboardFragment.setCallback(new DashboardCallback() {
            @Override
            public void someCallback() {

            }
        });
        HomeFragment.setCallback(new HomeCallback() {
            @Override
            public void someCallback() {

            }
        });
        NotificationsFragment.setCallback(new NotificationsCallback() {
            @Override
            public void someCallback() {

            }
        });

    }


    // методы для установки методов обратного вызова в активность из фрагментов навигации
    public static void setDashboardCallback(SampleNavigationActivityCallback allChatsActivityCallback) {
        SampleBottomNavigationActivity.dashboardCallback = allChatsActivityCallback;
    }
    public static void setHomeCallback(SampleNavigationActivityCallback myChatsActivityCallback) {
        SampleBottomNavigationActivity.homeCallback = myChatsActivityCallback;
    }
    public static void setNotificationsCallback(SampleNavigationActivityCallback mapActivityCallback) {
        SampleBottomNavigationActivity.notificationsCallback = mapActivityCallback;
    }


}