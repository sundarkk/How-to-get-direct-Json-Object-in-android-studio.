package com.sundar.ezetapandroidassignmen.classes;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import com.sundar.ezetapandroidassignmen.R;

import org.aviran.cookiebar2.CookieBar;

import java.util.regex.Pattern;
/**
 * Created by Sundar Chaupal (yr developer)on 03-09-2021.
 */
public class HelperClass {


    public static boolean isValidMobile(String phone) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            if (phone.length() < 9 || phone.length() > 13) {
                // if(phone.length() != 10) {
                check = false;
                // txtPhone.setError("Not Valid Number");
            } else {
                check = android.util.Patterns.PHONE.matcher(phone).matches();
            }
        } else {
            check = false;
        }
        return check;
    }

    public static void showErrorBarAlert(Activity activity, String title, String message, int icon, int gravity) {
        CookieBar.build(activity)
                .setTitle(title)
                .setTitleColor(R.color.white)
                .setBackgroundColor(R.color.resend_color)
                .setIcon(icon)
                .setCookiePosition(gravity)
                .setMessage(message)
                .setMessageColor(R.color.white)
                .setDuration(3000) // 3 seconds
                .show();
    }

    public static void snackbar(Context context, ViewGroup layout, String message) {
        Snackbar.make(layout, message, Snackbar.LENGTH_LONG)
                .setAction(context.getString(R.string.hide), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setActionTextColor(context.getResources().getColor(R.color.white))
                .show();
    }

    /*public static void hideLoader() {
        try {
            customLoader.dismiss();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }*/

    public static boolean getNetworkInfo(Context activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected() == true;
    }

    public static void setBannerImage(String url, ImageView imageView, Activity activity) {
        if (url == null) {
            Picasso.with(activity).load(R.drawable.banner_placeholder).into(imageView);
        } else if (url.isEmpty()) {
            Picasso.with(activity).load(R.drawable.banner_placeholder).into(imageView);
        } else {
            Picasso.with(activity).load(url).placeholder(R.drawable.banner_placeholder).into(imageView);
        }
    }
}
