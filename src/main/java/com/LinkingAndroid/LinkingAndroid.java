package com.upinion.LinkingAndroid;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;

public class LinkingAndroid extends ReactContextBaseJavaModule {

    private Context context;

    /**
     * Constructor for the Native Module
     * @param  reactContext  React context object to comunicate with React-native
     */
    public LinkingAndroid(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    /**
     * Returns the name of this module in React-native (javascript)
     */
    @Override
    public String getName() {
        return "LinkingAndroid";
    }

    /**
     * Function to be shared to React-native, it starts an activity with the given email to write to
     * @param  url  String with the email to use
     */
    @ReactMethod
    public void show(String uri) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.context.startActivity(emailIntent);
    }


}
