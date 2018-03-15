package com.banana.arduinocontroller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main_Activity_Controller extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        updateTheme();
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    private void updateTheme(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = preferences.getString("pref_theme","Light");
        if(theme.equals("Light")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.AppTheme_Dark);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals("pref_theme")){
            recreate();
        }
    }
}
