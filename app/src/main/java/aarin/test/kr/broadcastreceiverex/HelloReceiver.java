package aarin.test.kr.broadcastreceiverex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by back on 2016-11-15.
 */

public class HelloReceiver extends BroadcastReceiver {
    private static final String TAG = "HELLORECEIVER";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(action.equals("aarin.test.kr.broadcastreceiverex.SEND_BROAD_CAST")) {
            Log.d(TAG, "BR ON");
            boolean isBoolean = intent.getBooleanExtra("isBoolean", false);
            int receiveInteger = intent.getIntExtra("sendInteger", -2);
            String receiveString = intent.getStringExtra("sendString");

            Toast.makeText(context, "Broadcast: bool = " + isBoolean
                    + ", integer = " + receiveInteger
                    + ", string = " + receiveString, Toast.LENGTH_LONG).show();
        } else {
            Log.d(TAG, "BR OFF");
        }
    }
}
