package android.com.galp.plugins.bipdrive;

import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.Bipdrive.Bipdrivecore;
import com.Bipdrive.Bipdrivecore.Utils;
import com.Bipdrive.Bipdriveparkingmeter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class GalpBipDriveImpl extends CordovaPlugin {

    static private CallbackContext _callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        _callbackContext = callbackContext;

        if (action.equals("launchParkingMeter")) {

            /**
            appId: 6^7&AL3rCbWl
            appKey: LqMY01d1!sbZz^g5Hu5BJOM9Qi75Ws3*6AdmpBV&M9bfvW6BT&
            clientId: f835071b-529a-4748-a883-cedd1f9c8411
             */
            BipDriveConfig bipDriveConfig = new BipDriveConfig(
                    "LqMY01d1!sbZz^g5Hu5BJOM9Qi75Ws3*6AdmpBV&M9bfvW6BT&",
                    "6^7&AL3rCbWl",
                    "f835071b-529a-4748-a883-cedd1f9c8411");

            BDParkingMeterLaunch.INSTANCE.launchParkingMeter(MainActivity.this, bipDriveConfig, new ConfigValidationResult(){
                @Override
                public void onValidationOK(@NotNull ConfigValidationResponse configValidationResponse) {

                }

                @Override
                public void onValidationKO(@NotNull BDErrorResponse bdErrorResponse) {
                    new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(MainActivity.this,
                            bdErrorResponse.toString(),
                            Toast.LENGTH_SHORT).show());
                }
            });
             return true;
        }
        return false;
    }

}