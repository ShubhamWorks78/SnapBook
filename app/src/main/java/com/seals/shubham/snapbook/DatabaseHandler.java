package com.seals.shubham.snapbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

/**
 * Created by shubham on 12/25/2016.
 */

public class DatabaseHandler {
    private static String TAG = DatabaseHandler.class.getSimpleName();

    SharedPreferences mSharedPreferences;

    Editor mEditor;
    Context mContext;

    //Mode of Shared Preference
    int MODE = 0;

    private static final String PREF_NAME = "SnapBookLogin";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_NAME = "name";
    private static final String KEY_TEAM = "team";

    public DatabaseHandler(Context context){
        this.mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME,MODE);
        mEditor = mSharedPreferences.edit();
    }
    public void setLogIn(boolean isLoggedIn,String token,String name,String team){
        mEditor.putBoolean(KEY_IS_LOGGEDIN,isLoggedIn);
        mEditor.putString(KEY_TOKEN,token);
        mEditor.putString(KEY_TEAM,team);
        mEditor.putString(KEY_NAME,name);

        mEditor.commit();

        Log.d(TAG,"User Login Session modified!");
    }

    public String getToken(){
        return mSharedPreferences.getString(KEY_TOKEN,null);
    }

    public boolean isLoggedIn(){
        return mSharedPreferences.getBoolean(KEY_IS_LOGGEDIN,false);
    }

    public String getName(){
        return mSharedPreferences.getString(KEY_NAME,null);
    }

    public String getTeam(){
        return mSharedPreferences.getString(KEY_TEAM,null);
    }


}
