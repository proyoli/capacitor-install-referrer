package com.eladcohen.capainstallref;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import java.util.Set;

@NativePlugin()
public class CapacitorInstallReferrer extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {

        Bundle extras = intent.getExtras();
        if (extras == null)
            return;

        JSObject ret = new JSObject();

        Set<String> keys = extras.keySet();

        for (String key : keys) {
            String value = extras.getString(key);
            ret.put(key, value);

        }


        call.success(ret);
    }
}
