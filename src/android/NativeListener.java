package com.taesiri.nativeview;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NativeListener extends CordovaPlugin {
    public static final String NATIVE_CALL_ACTION = "nativeCall";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (NATIVE_CALL_ACTION.equals(action)) {
                JSONObject arg_object = args.getJSONObject(0);

                 String data = arg_object.getString("params");
                
                Context context = cordova.getActivity().getApplicationContext();
                
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, data, duration);
                toast.show();
                
               callbackContext.success();
               return true;
            } 

            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}


