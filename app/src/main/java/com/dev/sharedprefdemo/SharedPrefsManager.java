package com.dev.sharedprefdemo;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsManager {

    private static final String TAG = "SharedPrefsManager";

    private Context context;
    private final int DEFAULT_INT_VALUE = -1234;
    private final String PREF_TAG = "USER_INFO", DEFAULT_STRING_VALUE = "DEFAULT_VALUE",
            AGE_TAG = "AGE_TAG", NOM_TAG = "NOM_TAG";

    public SharedPrefsManager(Context context) {
        this.context = context;
    }

    public void saveUserInfo(int age, String nom) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(AGE_TAG, age);
        editor.putString(NOM_TAG, nom);
        editor.apply();
    }

    public String getUserFromPrefData() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_TAG, Context.MODE_PRIVATE);
        boolean isAgeEmpty = sharedPreferences.getInt(AGE_TAG, DEFAULT_INT_VALUE) == DEFAULT_INT_VALUE,
                isNameEmpty = sharedPreferences.getString(NOM_TAG, DEFAULT_STRING_VALUE).equals(DEFAULT_STRING_VALUE);

        return isAgeEmpty || isNameEmpty ? null : sharedPreferences.getString(NOM_TAG, DEFAULT_STRING_VALUE);
    }

    public void clearUserData() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}