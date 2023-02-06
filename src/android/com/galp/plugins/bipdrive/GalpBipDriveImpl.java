package android.com.galp.plugins.bipdrive;

import android.content.Intent;
import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jetbrains.annotations.NotNull;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
//import android.support.v4.content.ContextCompat;
import android.R;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
 
import com.bipdrive.bipdrivecore.BipDriveCore;
import com.bipdrive.bipdrivecore.BipDriveConfig;
import com.bipdrive.bipdrivecore.datamanager.BDErrorResponse;
import com.bipdrive.bipdrivecore.datamanager.clientinfo.params.NeedsUpgradeResult;
import com.bipdrive.bipdrivecore.datamanager.configvalidation.ConfigValidationResponse;
import com.bipdrive.bipdrivecore.datamanager.configvalidation.ConfigValidationResult;
import com.bipdrive.bipdrivecore.utils.BDLauncher;
import com.bipdrive.bipdriveparkingmeter.BDParkingMeterLaunch;

public class GalpBipDriveImpl extends CordovaPlugin {

    final static String LAUNCH_PARKING_METER = "launchParkingMeter";

    private String appId;
    private String appKey;
    private String clientId;

    static private CallbackContext _callbackContext;

    CordovaInterface mCordova;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        _callbackContext = callbackContext;


        if (LAUNCH_PARKING_METER.equals(action)) {
            this.launchParkingMeter(args, callbackContext);
            return true;
        } 

         
        return false;
    }

      private void launchParkingMeter(final JSONArray args, final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {

                    System.out.println("launchParkingMeter");
                    
                    System.out.println(appId);
                    System.out.println(appKey);
                    System.out.println(clientId);
                    
                     BipDriveConfig bipDriveConfig = new BipDriveConfig(
                    "LqMY01d1!sbZz^g5Hu5BJOM9Qi75Ws3*6AdmpBV&M9bfvW6BT&",
                    "6^7&AL3rCbWl",
                    "f835071b-529a-4748-a883-cedd1f9c8411");
  
            BDParkingMeterLaunch.INSTANCE.launchParkingMeter(mCordova.getActivity(), "en", bipDriveConfig, R.drawable.alert_dark_frame, ContextCompat.getColor(mCordova.getActivity(), R.color.background_dark), new ConfigValidationResult() {

               @Override
               public void onValidationOK(@NotNull ConfigValidationResponse configValidationResponse) {

               }

               @Override
               public void onValidationLoaded() {

               }

               @Override
               public void onValidationKO(@NotNull BDErrorResponse bdErrorResponse) {

               }

            }, new NeedsUpgradeResult() {

                @Override
                public void onNeedsUpgrade() {

                }

            });   

                    callbackContext.success();
                } catch (Exception ex) {
                    final String errorMessage = String.format("Exception in call to dispatchEvent: %s", ex.getLocalizedMessage());
                    callbackContext.error(errorMessage);
                }
            }
        });
    }

     @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        mCordova = cordova;
        
        
        appId = cordova.getActivity().getString(cordova.getActivity().getResources().getIdentifier("appId", "string", cordova.getActivity().getPackageName()));
        appKey = cordova.getActivity().getString(cordova.getActivity().getResources().getIdentifier("appKey", "string", cordova.getActivity().getPackageName()));
        clientId = cordova.getActivity().getString(cordova.getActivity().getResources().getIdentifier("clientId", "string", cordova.getActivity().getPackageName()));
 
        System.out.println("appId: " + appId);
        System.out.println("appKey: " + appKey);
        System.out.println("clientId: " + clientId);

        try {
            
            System.out.println("initialize completed");

        } catch (Exception e) {
            System.out.println(e);
        }

     }

}