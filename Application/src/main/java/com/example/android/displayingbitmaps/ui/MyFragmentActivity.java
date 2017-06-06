package com.example.android.displayingbitmaps.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.crashlytics.android.Crashlytics;
import com.example.android.displayingbitmaps.MyFragment1;
import com.example.android.displayingbitmaps.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;

import io.fabric.sdk.android.Fabric;

public class MyFragmentActivity extends FragmentActivity {

    private static final String TAG = "MyFragmentActivity";

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);

        //crashlytics
        Fabric.with(this, new Crashlytics());

        // ユーザープロパティの設定
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setUserProperty("favorite_image", "image1");

        String name = "image1";
        String text = "I'd love you to hear about " + name;


/*
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "10");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "name");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text");
        mAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
*/
        Bundle params = new Bundle();
        params.putString("image_name", name);
        params.putString("full_text", text);
        mFirebaseAnalytics.logEvent("share_image", params);

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        android.util.Log.d(TAG, "Refreshed token: " + refreshedToken);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contents);
        if (fragment == null)
        {
            fragment = new MyFragment1();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.contents,fragment);
            fragmentTransaction.commit();
        }
    }

}
