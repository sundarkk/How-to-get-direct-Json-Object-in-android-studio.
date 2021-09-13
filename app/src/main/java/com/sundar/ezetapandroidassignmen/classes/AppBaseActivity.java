package com.sundar.ezetapandroidassignmen.classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;

import org.aviran.cookiebar2.CookieBar;
/**
 * Created by Sundar Chaupal (yr developer)on 03-09-2021.
 */
public class AppBaseActivity extends AppCompatActivity {
    Context context = getBaseContext();
    private Activity activity;


    public void disableOrientation(){
        setRequestedOrientation(getResources().getConfiguration().orientation);
    }
    public void enableOrientation(){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
    }
    @Override
    protected void attachBaseContext(Context ctx) {
        this.context = ctx;
        super.attachBaseContext(context);

    }

    @Override
    protected void onPause() {
        super.onPause();
        CookieBar.dismiss(this);

    }


}
