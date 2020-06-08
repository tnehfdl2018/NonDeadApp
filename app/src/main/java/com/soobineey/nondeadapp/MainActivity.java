package com.soobineey.nondeadapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private RestartService restartService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("MainActivity", "onDestroy");

        unregisterReceiver(restartService);
    }

    private void initData() {
        restartService = new RestartService();
        intent = new Intent(MainActivity.this, PersistentService.class);

        IntentFilter intentFilter = new IntentFilter("com.soobineey.nondeadapp.PersistentService");
        registerReceiver(restartService, intentFilter);
        startService(intent);
    }
}
