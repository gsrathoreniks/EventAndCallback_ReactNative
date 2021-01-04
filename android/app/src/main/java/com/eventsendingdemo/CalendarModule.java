package com.eventsendingdemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class CalendarModule extends ReactContextBaseJavaModule {
    private static final String TAG = "CalendarModule";
    public ReactApplicationContext context;

    public CalendarModule(ReactApplicationContext context) {
        this.context = context;

        Log.d(TAG, "CalendarModule: "+context);

    }

    @Override
    public void initialize() {
        super.initialize();
        disconnectCallEvent(context);
    }

    public void disconnectCallEvent(ReactApplicationContext context){
        if(context != null) {
            WritableMap params = Arguments.createMap();
            params.putString("action","hangup");

            context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit("eventHangup", params);

            Log.d(TAG, "onCreate: EVENT SEND");
        } else {
            Log.d(TAG, "disconnectCallEvent: CONTEXT IS NULL");
        }
    }

    @Override
    public String getName() {
        return "CalendarModule";
    }

    // add to CalendarModule.java
    @ReactMethod
    public void isCallDisconnected(String callback) {
        Toast.makeText(context,"Call Disconnect callback  - "+callback,Toast.LENGTH_LONG).show();
    }
}
