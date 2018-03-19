package com.banana.arduinocontroller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class Main_Activity_Controller extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        updateTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        addPreferencesFromResource(R.xml.settings);
        Toolbar toolbar = findViewById(R.id.Toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v){
                    finish();
                }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.registerOnSharedPreferenceChangeListener(this);

        updateBluetoothAddressSummary();
        updateThemeSummary();
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
        } else if (s.equals("pref_address")) {
            updateBluetoothAddressSummary();
        }
    }

    private void updateBluetoothAddressSummary(){
     Preference preference =  findPreference("pref_address");
     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
     String value = preferences.getString("pref_address", "ДЕФОЛТ");
     preference.setSummary(value);
    }
    private void updateThemeSummary(){
        Preference preference = findPreference("pref_theme");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String value = preferences.getString("pref_theme","default");
        preference.setSummary(value);
    }
}
