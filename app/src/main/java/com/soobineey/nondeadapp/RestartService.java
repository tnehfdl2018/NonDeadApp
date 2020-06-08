package com.soobineey.nondeadapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RestartService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("RestartService", "RestartService" + intent.getAction());

        if (intent.getAction().equals("ACTION.RESTART.PersistenService")) {
            Log.i("RestartService", "ACTION.RESTART.PersistentService");

            Intent in = new Intent(context, PersistentService.class);
            context.startService(in);
        }

        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED )) {
            Log.i("RestartService", "ACTION_BOOT_COMPLETED");

            Intent in = new Intent(context, PersistentService.class);
            context.startService(in);
        }
    }
}
