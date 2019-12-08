package com.eladcohen.capainstallref;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.content.SharedPreferences.Editor;
import android.app.Activity;

import java.util.Set;

@NativePlugin()
public class Receiver extends BroadcastReceiver {

    private static final String PREFS_NAME = "CapacitorStorage";
    private static final String TAG = "InstallReceiver";

    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "Context: " + context);
        Bundle extras = intent.getExtras();
        if (extras == null)
            return;

        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        Editor edit = sharedPreferences.edit();

        Set<String> keys = extras.keySet();

        for (String key : keys) {
            String value = extras.getString(key);
            edit.putString(key, value);
        }

        edit.commit();
    }
}
