package com.example.zhimer.studentdesk;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    private static final String KEY_BERITA = "pengumuman";

    int PRIVATE_MODE = 0;

    public SessionManager(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(KEY_BERITA, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setAPI(String data)
    {
        editor.putString("JsonApiBerita", data);
        editor.commit();
    }


    public String getAPI()
    {
        return sharedPreferences.getString("JsonApiBerita", null);
    }
}
